package com.Project.Security.feign;

//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.Project.Security.dto.Train;
//
//@FeignClient("TRAINSERVICE")
//public interface SecurityInterface {
//
//	@GetMapping("/getalltrains")
//	public ResponseEntity<List<Train>> getAllTrains();
//	@GetMapping("/getby/source/{source}/destination/{destination}/{starttime}/{endtime}/available")
//	public ResponseEntity<List<Train>> getTrainBySourceAndDestinationByAvailability(
//	    @PathVariable String source,
//	    @PathVariable String destination,
//	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime starttime,
//	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endtime);
//	
//	@PostMapping("/addtrain")
//	public ResponseEntity<String> addTrain(@RequestBody Train train);
//	@DeleteMapping("delete/{trainID}")
//	public ResponseEntity<String> deleteTrain(@PathVariable int trainID);
//	@PutMapping("update/{trainID}")
//	public ResponseEntity<String> updateTrain(@PathVariable int trainID,@RequestBody Train train);
//	@PutMapping("update/{trainID}/{seats}")
//	public ResponseEntity<String> updateseats(@PathVariable int trainID,@PathVariable int seats);
//	@PutMapping("addseats/{trainID}/{seats}")
//	public ResponseEntity<String> addseats(@PathVariable int trainID,@PathVariable int seats);
//}
