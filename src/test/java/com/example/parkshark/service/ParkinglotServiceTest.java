package com.example.parkshark.service;

import com.example.parkshark.domain.dto.address.CreateAddressDto;
import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.dto.person.CreatePersonDto;
import com.example.parkshark.domain.parkinglot.ParkinglotCategory;
import com.example.parkshark.exceptions.*;
import com.example.parkshark.mapper.ParkinglotMapper;
import com.example.parkshark.repository.DivisionRepository;
import com.example.parkshark.repository.ParkinglotRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

class ParkinglotServiceTest {

    private ParkinglotRepository parkinglotRepositoryMock;
    private DivisionRepository divisionRepositoryMock;
    private ParkinglotService parkinglotService;
    private ParkinglotMapper parkinglotMapperMock;

    private CreateParkinglotDto createParkinglotDto;

    @BeforeEach
    void setupParkinglotService() {
        parkinglotRepositoryMock = Mockito.mock(ParkinglotRepository.class);
        divisionRepositoryMock = Mockito.mock(DivisionRepository.class);
        parkinglotMapperMock = Mockito.mock(ParkinglotMapper.class);
        parkinglotService = new ParkinglotService(parkinglotRepositoryMock, divisionRepositoryMock, parkinglotMapperMock);

        createParkinglotDto = new CreateParkinglotDto(
                "ParkinglotName",
                ParkinglotCategory.UNDERGROUND.getType(),
                250,
                new CreatePersonDto(
                        "Firstname",
                        "Lastname",
                        new CreateAddressDto(
                                "Streetname",
                                101,
                                9000,
                                "Gent"
                        ),
                        "098765432",
                        "0498765432",
                        "email@email.com"
                ),
                new CreateAddressDto(
                        "Streetname",
                        101,
                        9000,
                        "Gent"
                ),
                2.5,
                13);

    }

    @Nested
    @DisplayName("check hasValidCategory()")
    class checkValidCategory {
        @DisplayName("Category Underground and Aboveground are given")
        @Test
        void whenCategoryIsUndergroundOrAboveground_ThenDoNotThrowAnException() {
            //GIVEN
            //WHEN

            //THEN
            Assertions.assertDoesNotThrow(() -> parkinglotService.hasValidCategory("Underground"));
            Assertions.assertDoesNotThrow(() -> parkinglotService.hasValidCategory("Aboveground"));
        }

        @DisplayName("Category is incorrect")
        @Test
        void whenInValidEmailIsGiven_ThenDoNotThrowAnException() {
            //GIVEN

            //WHEN

            //THEN
            Assertions.assertThrows(EmptyParkinglotCategoryException.class, () -> parkinglotService.hasValidCategory(null));
            Assertions.assertThrows(ParkinglotCategoryDoesNotExistException.class, () -> parkinglotService.hasValidCategory("test"));
        }
    }

    @Nested
    @DisplayName("check hasValidDivision()")
    class checkValidDivision {
        // TODO fix database for test
//        @DisplayName("Division exist")
//        @Test
//        void whenCategoryIsUndergroundOrAboveground_ThenDoNotThrowAnException() {
//            //GIVEN
//            //WHEN
//
//            //THEN
//            Assertions.assertDoesNotThrow(() -> parkinglotService.hasValidDivisionId(13));
//        }

        @DisplayName("Category is incorrect")
        @Test
        void whenInValidCategoryIsGiven_ThenDoNotThrowAnException() {
            //GIVEN

            //WHEN

            //THEN
            Assertions.assertThrows(EmptyParkinglotCategoryException.class, () -> parkinglotService.hasValidCategory(null));
            Assertions.assertThrows(ParkinglotCategoryDoesNotExistException.class, () -> parkinglotService.hasValidCategory("test"));
        }
    }


}

  /*  @Test
    void whenParkingLotIsAdded_thenParkinglotRepositorySaveMethodIsCalledOneTime() {

        //when
        parkinglotService.createParkinglot(createParkinglotDto);

        //then
        Mockito.verify(parkinglotRepositoryMock, times(1)).save(Mockito.any());
    }

    @Test
    void whenGetAllParkinglots_thenParkinglotRepositoryFindAllAllMethodIsCalledOneTime() {

        //when
        parkinglotService.getAll();

        //then
        Mockito.verify(parkinglotRepositoryMock, times(1)).findAll();
    }

//    @Test
//    void whenGetParkinglotById_thenParkinglotRepositoryFindByIdMethodIsCalledOneTime() {
//        //given
//        Integer randomId = 100;
//        ParkinglotDto parkinglotDto = new ParkinglotDto();
//
//        //when
//        //Mockito.when(parkinglotService.getById("1")).thenReturn(parkinglotDto);
//        parkinglotService.getById("100");
//        Mockito.verify(parkinglotRepositoryMock, times(1)).findById(100);
//    }

    @Nested
    @DisplayName("check hasValidTelephoneNumberMethod()")
    class checkPhoneNumber {
        @DisplayName("Correct phoneNumber of nine and Ten numbers -> hasValidPhoneNumber method -> true")
        @Test
        void whenValidPhoneNumbersIsPassed_ThenTheValueReturnedFromTheValidationMethodIsTrue() {
            //GIVEN
            String telephoneNumber = "098765432";
            String telephoneNumber2 = "0487211399";
            //WHEN

            //THEN
            Assertions.assertTrue(parkinglotService.hasValidTelephoneNumber(telephoneNumber));
            Assertions.assertTrue(parkinglotService.hasValidTelephoneNumber(telephoneNumber2));

        }

        @DisplayName("Invalid phoneNumbers -> hasValidPhoneNumber method -> false")
        @Test
        void whenAInValidPhoneNumberIsPassed_ThenTheValueReturnedFromTheValidationMethodIsFalse() {
            //GIVEN
            String telephoneNumber = "09871812";
            String telephoneNumber2 = "09871812121";
            //WHEN

            //THEN
            Assertions.assertFalse(parkinglotService.hasValidTelephoneNumber(telephoneNumber));
            Assertions.assertFalse(parkinglotService.hasValidTelephoneNumber(telephoneNumber2));

        }

    }

    @Nested
    @DisplayName("check hasValidTelephoneNumber()")
    class checkHasValidTelephoneNumber {
        @DisplayName("If valid Telephone number is present but no mobile number -> No exception")
        @Test
        void whenValidTelephoneNumberIsGivenButNoMobileNumber_ThenThereIsNoException() {
            //GIVEN
            String telephoneNumber = "098765432";
            String mobileNumber = null;
            //WHEN

            //THEN
            Assertions.assertDoesNotThrow(() -> parkinglotService.hasValidTelephone(telephoneNumber, mobileNumber));
        }

        @DisplayName("If valid mobile number is present but no telephone number -> No exception")
        @Test
        void whenValidMobileNumberIsGivenButNoTelephoneNumber_ThenThereIsNoException() {
            //GIVEN
            String telephoneNumber = null;
            String mobileNumber = "0487211399";
            //WHEN

            //THEN
            Assertions.assertDoesNotThrow(() -> parkinglotService.hasValidTelephone(telephoneNumber, mobileNumber));
        }

        @DisplayName("If valid mobile number and telephone number are absent -> THROW exception")
        @Test
        void whenValidMobileNumberAndTelephoneAreGiven_ThenThereIsAException() {
            //GIVEN
            String telephoneNumber = null;
            String mobileNumber = null;
            //WHEN

            //THEN
            Assertions.assertThrows(InvalidTelephoneException.class, () -> parkinglotService.hasValidTelephone(telephoneNumber, mobileNumber));
        }
    }

    @Nested
    @DisplayName("check hasValidEmail()")
    class checkValidEmail {
        @DisplayName("Valid email is given")
        @Test
        void whenValidEmailIsGiven_ThenDoNotThrowAnException() {
            //GIVEN
            String email = "test@gmail.com";
            //WHEN

            //THEN
            Assertions.assertDoesNotThrow(() -> parkinglotService.hasValidEmailAddress(email));
        }

        @DisplayName("Email is incorrect")
        @Test
        void whenInValidEmailIsGiven_ThenDoNotThrowAnException() {
            //GIVEN
            String email = "test@gmailcom";
            String email2 = "testgmail.com";
            //WHEN

            //THEN
            Assertions.assertThrows(InvalidEmailException.class, () -> parkinglotService.hasValidEmailAddress(email));
            Assertions.assertThrows(InvalidEmailException.class, () -> parkinglotService.hasValidEmailAddress(email2));
            Assertions.assertThrows(InvalidEmailException.class, () -> parkinglotService.hasValidEmailAddress(null));
        }
    }
}*/