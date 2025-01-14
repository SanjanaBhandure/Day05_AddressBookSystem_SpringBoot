package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressbookData;
import com.bridgelabz.addressbookapp.services.IAddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressbookController {

    @Autowired
    IAddressbookService addressbooService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbooService.getAddressbookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable(value = "personId") int personId) {
        AddressbookData addressbookData = null;
        addressbookData = addressbooService.getAddressbookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id is successfully",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = addressbooService.createAddressbooData(addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data successfully ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressbookData( @PathVariable int personId,@Valid @RequestBody AddressbookDTO addressbookDTO){
        AddressbookData addressbookData = null;
        addressbookData = addressbooService.updateAddressbookData(personId,addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll data successfully ",addressbookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("personId") int personId) {
        addressbooService.deleteAddressbooData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully","person id: "+personId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortAddressBookByCity(){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbooService.sortAddressBookByCity();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By City Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getByCity/{city}")
    public ResponseEntity<ResponseDTO> getAddressBookByCity(@PathVariable String city){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbooService.getAddressBookByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By City Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDTO> sortAddressBookByState(){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbooService.sortAddressBookByState();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By State Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getByState/{state}")
    public ResponseEntity<ResponseDTO> getAddressBookByState(@PathVariable String state){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbooService.getAddressBookByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By State Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByZip")
    public ResponseEntity<ResponseDTO> sortAddressBookByZip(){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbooService.sortAddressBookByZip();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By Zip Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getByZip/{zip}")
    public ResponseEntity<ResponseDTO> getAddressBookByZip(@PathVariable String zip){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbooService.getAddressBookByZip(zip);
        ResponseDTO responseDTO = new ResponseDTO("Get AddressBook By Zip Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/sortByName")
    public ResponseEntity<ResponseDTO> sortAddressBookByName(){
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbooService.sortAddressBookByName();
        ResponseDTO responseDTO = new ResponseDTO("sort AddressBook By Name Success",addressbookDataList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
