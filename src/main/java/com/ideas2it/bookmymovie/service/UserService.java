package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.dto.responseDto.BookingResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * <p>
 * This {@Code UserService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */

public interface UserService extends UserDetailsService {

    /**
     * <p>
     * This method is used to create customer detail
     * </p>
     *
     * @param userDto it contains user dto objects.
     * @return UserDto
     */
    UserResponseDto createUser(UserDto userDto);

    /**
     * <p>
     * This method List all the User Details
     * </p>
     *
     * @return List<UserDto>
     */
    List<UserResponseDto> getAllUsers(int pageNumber, int pageSize);

    /**
     * <p>
     * This method get the User Details which matches the id
     * </p>
     *
     * @param id it contains user id
     * @return UserDto
     */
    UserDto getUserById(int id);

    /**
     * <p>
     * This method is to update the user details
     * </p>
     *
     * @param userDto it contains user dto objects.
     * @return ScreenDto
     */
    UserDto updateUser(UserDto userDto);

    /**
     * <p>
     * This method get the Booking Details of the user
     * </p>
     *
     * @param userId it contains booking id
     * @return BookingResponseDto
     */
    List<BookingResponseDto> viewBookingByUserId(int userId);
}
