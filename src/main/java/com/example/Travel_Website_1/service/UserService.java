package com.example.Travel_Website_1.service;



import com.example.Travel_Website_1.model.User;
import com.example.Travel_Website_1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
@Service

public class UserService  implements UserInterface {

    @Autowired
    private UserRepository userRepository;



    //     method for add user
    @Override
    public User addUser(User user) {

        if(verifyEmail(user.getEmail())){

            user.setEmail(user.getEmail());

        }

        if(verifyCNP(user.getCnp()))
        {
            user.setCnp(user.getCnp());
            user.setPassword(generatePassword());
        }
        else
        {   return null;}
        return userRepository.save(user);
    }

    public boolean verifyEmail(String email) {
        String emailRegex = "^[\\w.*\\-]+@gmail\\.com";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }
    @Override
    public User updateUser(Long userId, User user) {
        User userDb = userRepository.findById(userId).get();

        if(Objects.nonNull(user.getUsername()) &&
                !"".equalsIgnoreCase(user.getUsername()))
        {
            userDb.setUsername(user.getUsername());
        }

        if(Objects.nonNull(user.getPassword()) &&
                !"".equalsIgnoreCase(user.getPassword()))
        {
            userDb.setPassword(user.getPassword());
        }

        if(Objects.nonNull(user.getCnp()) &&
                !"".equalsIgnoreCase(user.getCnp()))
        {
            userDb.setCnp(user.getCnp());
        }

        if(Objects.nonNull(user.getPhoneNumber()) &&
                !"".equalsIgnoreCase(user.getPhoneNumber()))
        {
            userDb.setPhoneNumber(user.getPhoneNumber());
        }


        if(Objects.nonNull(user.getEmail()) &&
                !"".equalsIgnoreCase(user.getEmail()))
        {
            userDb.setEmail(user.getEmail());
        }

        if(verifyEmail(userDb.getEmail())){

            user.setEmail(userDb.getEmail());

        }

        if(verifyCNP(userDb.getCnp()))
        {
            user.setCnp(userDb.getCnp());
            user.setPassword(generatePassword());
        }
        else
        {   return null;}


        return  userRepository.save(userDb);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long theId) {
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;

        if (result.isPresent()) {
            theUser= result.get();
        }
        else {
            // we didn't find the employee
            throw new itschool.springframework.exceptions.NotFoundException("Recipe Not Found. For ID value: " + theId.toString());

        }

        return theUser;
    }



    public static String generatePassword() {
        Random random = new Random();
        String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0987654321";
        String specialChars = "!@#$%^&*+-";
        String allCharacters = alphabetLowerCase + alphabetUpperCase + digits + specialChars;

        List<Character> passwordChars = new ArrayList<>();
        passwordChars.add(alphabetLowerCase.charAt(random.nextInt(alphabetLowerCase.length())));
        passwordChars.add(alphabetUpperCase.charAt(random.nextInt(alphabetUpperCase.length())));
        passwordChars.add(digits.charAt(random.nextInt(digits.length())));
        passwordChars.add(specialChars.charAt(random.nextInt(specialChars.length())));

        int minLength = 2;
        int maxLength = 8;
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        for(int i=0; i<length; i++) {
            passwordChars.add(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        Collections.shuffle(passwordChars);
        StringBuilder password = new StringBuilder();
        for(char ch : passwordChars) {
            password.append(ch);
        }
        return password.toString();
    }

    public static boolean verifyCNP(String cnp) {
        if (cnp.length() != 13 || !hasDigits(cnp) || !verifyFormatMonth(cnp) || !verifyFormatYear(cnp)) {
            return false;
        }
        return true;
    }

    private static boolean verifyFormatYear(String cnp) {
        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
            String year = cnp.substring(1, 3);
            int yearAsInt = Integer.parseInt(year);
            return yearAsInt >= 0 && yearAsInt <= 99;
        } else if (cnp.charAt(0) == '5' || cnp.charAt(0) == '6') {
            String year = cnp.substring(1, 3);
            int yearAsInt = Integer.parseInt(year);
            return yearAsInt >= 0 && yearAsInt <= 21;
        }
        return false;
    }

    private static boolean verifyFormatMonth(String cnp) {
        String year = cnp.substring(1, 3);
        int yearAsInt = Integer.parseInt(year);
        String month = cnp.substring(3, 5);
        int monthAsInt = Integer.parseInt(month);
        String day = cnp.substring(5, 7);
        int dayAsInt = Integer.parseInt(day);
        if (monthAsInt < 1 || monthAsInt > 12) {
            return false;
        } else {
            if (monthAsInt == 1 || monthAsInt == 3 || monthAsInt == 5 || monthAsInt == 7 ||
                    monthAsInt == 8 || monthAsInt == 10 || monthAsInt == 12) {
                return dayAsInt >= 1 && dayAsInt <= 31;
            } else if (monthAsInt == 4 || monthAsInt == 6 || monthAsInt == 9 || monthAsInt == 11) {
                return dayAsInt >= 1 && dayAsInt <= 30;
            } else {
                if (yearAsInt % 4 == 0) {
                    return dayAsInt >= 1 && dayAsInt <= 29;
                } else {
                    return dayAsInt >= 1 && dayAsInt <= 28;
                }
            }
        }
    }

    private static boolean hasDigits(String cnp) {
        for (int i = 0; i < cnp.length(); i++) {
            if (!Character.isDigit(cnp.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    @Override
    public void deleteById(long userId) {
        userRepository.deleteById(userId);
    }

}

/*<td
                <div class="col-small">
            <!-- Add "update" button/link -->
            <form action="#" th:action="@{/showFormForUpdateHotel}" method="POST">

                <input type="hidden" name="hotelId" th:value="${listHotels.hotelId}" />
                <button type="submit" class="btn btn-primary btn-sm ml-3 mr-1">View</button>

            </form>

        <td>

                <div class="col-small">
                    <!-- Add "update" button/link -->
                    <form action="#" th:action="@{/showFormForUpdateHotel}" method="POST">

                        <input type="hidden" name="hotelId" th:value="${listHotels.hotelId}" />
                        <button type="submit" class="btn btn-primary btn-sm ml-3 mr-1">Update</button>

                    </form>
                </div>
            </td>
            <td>
                <!--Delete-->
                <form action="#" th:action="@{/deleteHotel}" method="POST">

                    <input type="hidden" name="hotelId" th:value="${listHotels.hotelId}" />
                    <button type="submit" class="btn btn-danger btn-sm"
                            onclick="if (!(confirm('Are you sure you want to delete this hotel?'))) return false">
                        Delete
                    </button>

                    </form>
                </div>
            </td>*/