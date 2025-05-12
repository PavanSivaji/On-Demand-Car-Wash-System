//package com.example.washerservice.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.example.washerservice.model.WasherModel;
//import com.example.washerservice.service.WasherService;
//
//public class WasherControllerTest {
//	
//	@Mock
//    private WasherService washerService;
//
//    @InjectMocks
//    private WasherController washerController;
//
//    private WasherModel washer;
//    
//    
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        washer = new WasherModel(15L, "Raju", 1234567890L,"ragu01@gmail.com","Lpu,Jalandhar,Punjab", 5212721252L, 50000, 26);
//    }
//    
//    @Test
//    void createWasherTest() {
//        when(washerService.add(washer)).thenReturn(washer);
//
//        WasherModel createdWasher = washerController.create(washer);
//
//        assertNotNull(createdWasher);
//        assertEquals(15L, createdWasher.getWid());
//        assertEquals("Raju", createdWasher.getWname());
//        assertEquals(1234567890L, createdWasher.getWphonenumber());
//        assertEquals("ragu01@gmail.com", createdWasher.getWemail());
//        assertEquals("Lpu,Jalandhar,Punjab", createdWasher.getWaddress());
//        assertEquals(5212721252L, createdWasher.getWasherNIC());
//        assertEquals(50000, createdWasher.getWsalary());
//        assertEquals(26, createdWasher.getWage());
//        verify(washerService, times(1)).add(washer);
//    }
//
//
//}
