package com.tushar.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.tushar.dto.Response;
import com.tushar.Model.Booking;
import com.tushar.Model.Buses;
import com.tushar.enumClasses.BookingStatuses;
import com.tushar.enumClasses.IsActive;
import com.tushar.enumClasses.YesNoPending;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/Booking")
public class BookingController extends BaseControler {

	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	private final RestTemplate restTemplate;
	private final String apiUrl = "http://site.bulksmsnagpur.net/sendsms?uname=zade12&pwd=zade12&senderid=HSHAND&";

	@PostMapping("/addBooking")
	public ResponseEntity<Map> addBooking(@RequestParam("customerId") String customerId,
			@RequestParam("customerName") String customerName, 
			@RequestParam("customerMob") String customerMob,
			@RequestParam("noOfPassenger") String noOfPassenger, 
			@RequestParam("description") String description,
			@RequestParam("busId") String busId, 
			@RequestParam("seater") String seater,
			@RequestParam("type") String type, 
			@RequestParam("fromPlace") String fromPlace,
			@RequestParam("toPlace") String toPlace, 
			@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, 
			@RequestParam("totalDate") String totalDate,
			@RequestParam("inCityORoutOfCity") String inCityORoutOfCity,
			@RequestParam("expectedtotalKM") String expectedtotalKM,
			@RequestParam("advanceAmountTransactionId") String advanceAmountTransactionId,
			@RequestParam("isAc") String isAc, 
			@RequestParam("typeOfTrip") String typeOfTrip,
			@RequestParam("destinations") String destinations) {
		try {

			Booking booking = new Booking();
			booking.setCustomerId(customerId);
			booking.setCustomerName(customerName);
			booking.setCustomerMob(customerMob);
			booking.setNoOfPassenger(noOfPassenger);
			booking.setDescription(description);
			booking.setBusId(busId);
			booking.setSeater(seater);
			booking.setType(type);
			booking.setFromPlace(fromPlace);
			booking.setToPlace(toPlace);
			booking.setFromDate(fromDate);
			booking.setToDate(toDate);
			booking.setTotalDate(totalDate);

			booking.setExpectedtotalKM(expectedtotalKM);
			booking.setAdvanceAmountTransactionId(advanceAmountTransactionId);
			booking.setCreateAt(new Date());
			booking.setIsAc(isAc == null || isAc == "" ? "AC" : isAc);// AC,NON-AC
			booking.setTypeOfTrip(typeOfTrip);
			booking.setDestinations(destinations);

			Buses buses2 = busServices.getBus(Integer.parseInt(busId));

			booking.setPerDayPrice(buses2.getPerExtraDayChange());
			if (inCityORoutOfCity.equals("inCity")) {
				booking.setPerKMPrice(buses2.getPerKMPriceInCity());
			} else {
				booking.setPerKMPrice(buses2.getPerKMPriceOutOfCity());
			}
			String bookingId =(String.valueOf(generateBookingId()));
			booking.setBookingId(bookingId);
			bookingRepo.save(booking);
			int id = booking.getId();

			Map m = new HashMap();
			m.put("status", true);
			m.put("message", "Success");
			m.put("id", id);
			m.put("bookingId", bookingId);
			
		getApiResponse(apiUrl, bookingId, customerName, busId, fromPlace, toPlace, type, description, customerMob);
			return new ResponseEntity<Map>(m, HttpStatus.OK);

		} catch (Exception e) {
			Map m = new HashMap();
			m.put("status", false);
			m.put("error", e.getMessage());
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private long generateBookingId() {
		Random random = new Random();
		return (long) (random.nextDouble() * 10000000000L);
	}

	@GetMapping("/BookingList")
	public ResponseEntity<Map> BookingList() {
		Map m = new HashMap();
		m.put("data", bookingRepo.findAllByOrderByIdDesc());
		m.put("status", true);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@GetMapping("/BookingList/Vender/{venderId}")
	public ResponseEntity<Map> BookingListVender(@PathVariable String venderId) {
		Map m = new HashMap();
		m.put("data", bookingRepo.findByVenderIdOrderByIdDesc(venderId));
		m.put("status", true);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@GetMapping("/BookingList/Vender/BookingPending")
	public ResponseEntity<Map> BookingListVenderAlloctionPending() {
		Map m = new HashMap();
		m.put("data",
				bookingRepo.findByIsVenderAllocatedAndIsVenderAcceptedBookingOrderByIdDesc(IsActive.N, YesNoPending.P));
		m.put("status", true);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@GetMapping("/BookingList/Vender/{venderId}/isVenderAcceptedBooking/{isVenderAcceptedBooking}")
	public ResponseEntity<Map> BookingListVender(@PathVariable String venderId,
			@PathVariable String isVenderAcceptedBooking) {
		Map m = new HashMap();
		m.put("data", bookingRepo.findByVenderIdAndIsVenderAcceptedBookingOrderByIdDesc(venderId,
				IsActive.valueOf(isVenderAcceptedBooking)));
		m.put("status", true);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@GetMapping("/BookingList/Vender/{venderId}/status/{bookingStatus}")
	public ResponseEntity<Map> BookingListVenderBookingStatus(@PathVariable String venderId,
			@PathVariable String bookingStatus) {
		Map m = new HashMap();
		m.put("data", bookingRepo.findByVenderIdAndBookingStatusOrderByIdDesc(venderId,
				BookingStatuses.valueOf(bookingStatus)));
		m.put("status", true);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@GetMapping("/BookingList/Customer/{customerId}")
	public ResponseEntity<Map> BookingListCsutomer(@PathVariable String customerId) {
		Map m = new HashMap();
		m.put("data", bookingRepo.findByCustomerIdOrderByIdDesc(customerId));
		m.put("status", true);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@GetMapping("/BookingList/Customer/{customerId}/bookingStatus/{bookingStatus}")
	public ResponseEntity<Map> BookingListCsutomer(@PathVariable String customerId,
			@PathVariable String bookingStatus) {
		Map m = new HashMap();
		m.put("data", bookingRepo.findByCustomerIdAndBookingStatusOrderByIdDesc(customerId,
				BookingStatuses.valueOf(bookingStatus)));
		m.put("status", true);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@GetMapping("/BookingById/{id}")
	public ResponseEntity<Map> BookingById(@PathVariable String id) {
		try {
			Map m = new HashMap();
			m.put("data", bookingServices.getBooking(Integer.parseInt(id)));
			m.put("status", true);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("e >>>" + e);
			Map m = new HashMap();
			m.put("status", false);
			m.put("error", e.getMessage());
			return new ResponseEntity<Map>(m, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateBooking/Vender/acceptBooking")
	public ResponseEntity<Map> updateBooking(@RequestParam("id") String id, @RequestParam("venderId") String venderId) {

		Booking booking2 = bookingServices.getBooking(Integer.parseInt(id));

		if (booking2.getIsVenderAllocated().toString() == "Y"
				|| booking2.getIsVenderAcceptedBooking().toString() == "Y") {
			Map m = new HashMap();
			m.put("status", false);
			m.put("message", "Alredy Other Vender Grap a Booking");
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} else {
			booking2.setVenderId(venderId);
			booking2.setIsVenderAllocated(IsActive.Y);
			booking2.setIsVenderAcceptedBooking(YesNoPending.Y);
			booking2.setUpdateAt(new Date());

			bookingServices.addBooking(booking2);
			Map m = new HashMap();
			m.put("status", true);
			m.put("message", "Update Sucess");
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		}
	}

	@PutMapping("/updateBooking/vender/CancelBooking")
	public ResponseEntity<Map> updateBookingVenderAction(@RequestParam("id") String id,
			@RequestParam("venderId") String venderId) {

		Booking booking2 = bookingServices.getBookingByVender(venderId, Integer.parseInt(id));

		booking2.setIsVenderAcceptedBooking(YesNoPending.P);
		booking2.setIsVenderAllocated(IsActive.N);
		booking2.setUpdateAt(new Date());

		bookingServices.addBooking(booking2);
		Map m = new HashMap();
		m.put("status", true);
		m.put("message", "Update Sucess");
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@PutMapping("/updateBooking/vender/assignBus/{id}")
	public ResponseEntity<Map> updateBookingVenderAssignBus(@RequestParam String venderBusId,
			@RequestParam String driverName, @RequestParam String driverMob, @RequestParam String driverLicence,
			@RequestParam(value = "driverPhoto", required = false) MultipartFile driverPhoto,
			@RequestParam String busNoPlate, @PathVariable String id) {

		String filename = driverPhoto == null ? "" : fileStorageService.storeFile(driverPhoto, "driverPhoto_" + id);

		Booking booking2 = bookingServices.getBooking(Integer.parseInt(id));

		booking2.setVenderBusId(venderBusId);
		booking2.setDriverName(driverName);
		booking2.setDriverMob(driverMob);
		booking2.setDriverLicence(driverLicence);
		booking2.setDriverPhoto(filename);
		booking2.setBusNoPlate(busNoPlate);
		booking2.setUpdateAt(new Date());

		bookingServices.addBooking(booking2);
		Map m = new HashMap();
		m.put("status", true);
		m.put("message", "Update Sucess");
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@PutMapping("/updateBooking/vender/driver/addDetails/{id}")
	public ResponseEntity<Map> updateBookingVenderDriverAddDetails(@RequestParam String pickUpPlace,
			@RequestParam String dropPlace, @RequestParam String startKM, @RequestParam String endKM,
			@RequestParam String totalKM, @RequestParam String tollPrice, @RequestParam String totalPrice,
			@RequestParam String bookingStatus, @PathVariable String id) {

		Booking booking2 = bookingServices.getBooking(Integer.parseInt(id));

		booking2.setPickUpPlace(pickUpPlace);
		booking2.setDropPlace(dropPlace);
		booking2.setStartKM(startKM);
		booking2.setEndKM(endKM);
		booking2.setTotalKM(totalKM);
		booking2.setTollPrice(tollPrice);
		booking2.setTotalPrice(totalPrice);
		booking2.setBookingStatus(BookingStatuses.valueOf(bookingStatus));
		booking2.setUpdateAt(new Date());

		bookingServices.addBooking(booking2);
		Map m = new HashMap();
		m.put("status", true);
		m.put("message", "Update Sucess");
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	public BookingController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getApiResponse(String apiUrl, String bookingId, String custName, String busId, String fromPlace,
			String toPlace, String description, String busType, String phone) {
		HttpHeaders headers = new HttpHeaders();
		StringBuilder sb = new StringBuilder();
		sb.append(apiUrl);
		String msg ="to=" + phone + "&msg=HI " + custName + " Confirmed ! Booking ID " + bookingId + ".Trip is "
				+ busType + " seater bus varient " + busId + " scheduled to start at " + fromPlace + " from pickup location "
				+ toPlace + " contact details of customer is " + description
				+ " ,please contact and share driver details and getting passenger list from customer. Check your trip details on bus hub app. "
				+ "- Team Bus Hub. HSHAND&route=T&peid=1701167533595874370&tempid=1707167568662378832";
		sb.append(msg);
		System.err.println(sb.toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(sb.toString(), HttpMethod.GET, entity, String.class);

		return response.getBody();
	}
	
	/*Bus Rent APIs Starts*/
	
	//Adding Pickup and drop location
	  @PutMapping("/{id}/locations")
		public ResponseEntity<Map> updatePickupAndDropLocation(@RequestParam String pickUpPlace,
				@RequestParam String dropPlace, @PathVariable String id) {

			Booking booking2 = bookingServices.getBooking(Integer.parseInt(id));

			booking2.setPickUpPlace(pickUpPlace);
			booking2.setDropPlace(dropPlace);
			booking2.setUpdateAt(new Date());

			bookingServices.addBooking(booking2);
			Map m = new HashMap();
			m.put("status", true);
			m.put("message", "Update Sucess");
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		}
	
}
