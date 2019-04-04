package validate;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mirko
 */
public class Validator {

    // ensures that quantity input is number between 0 and 99
    // applies to quantity fields in cart page
    public boolean validateQuantity(String productId, String quantity, HttpServletRequest request) {

        boolean errorFlag = false;
        boolean errorWrongQuantity;
        boolean errorQuantityEmpty;

        if (!productId.isEmpty() && !quantity.isEmpty()) {

            int i = -1;

            try {
                i = Integer.parseInt(quantity);
            } catch (NumberFormatException nfe) {
                System.out.println("User did not enter a number in the quantity field");
            }


            if (i < 0 || i > 99) {

                errorFlag = true;
                errorWrongQuantity = true;
                request.setAttribute("errorWrongQuantity", errorWrongQuantity);
            }
        }

        if (quantity.isEmpty()) {
            errorFlag = true;
            errorQuantityEmpty = true;
            request.setAttribute("errorQuantityEmpty", errorQuantityEmpty);
        }

        return errorFlag;
    }

    // performs simple validation on checkout form
    public boolean validateForm(String name,
            String email,
            String phone,
            String address,
            String city,
            String country,
            HttpServletRequest request) {

        boolean errorFlag = false;
        boolean nameError;
        boolean emailError;
//        boolean phoneError;
        boolean addressError;
        boolean cityError;
        boolean countryError;

        if (name == null
                || name.equals("")
                || name.length() > 25) {
            errorFlag = true;
            nameError = true;
            request.setAttribute("nameError", nameError);
        }
        if (email == null
                || email.equals("")
                || !email.contains("@")) {
            errorFlag = true;
            emailError = true;
            request.setAttribute("emailError", emailError);
        }
//        if (phone == null
//                || phone.equals("")
//                || phone.length() < 9) {
//            errorFlag = true;
//            phoneError = true;
//            request.setAttribute("phoneError", phoneError);
//        }
        if (address == null
                || address.equals("")
                || address.length() > 25) {
            errorFlag = true;
            addressError = true;
            request.setAttribute("addressError", addressError);
        }
        if (city == null
                || city.equals("")
                || city.length() > 15) {
            errorFlag = true;
            cityError = true;
            request.setAttribute("cityError", cityError);
        }
        if (country == null
                || country.equals("")
                || country.length() > 30) {
            errorFlag = true;
            countryError = true;
            request.setAttribute("countryError", countryError);
        }

        return errorFlag;
    }

    public boolean validateFormContactUs(String name, String email, String comment, HttpServletRequest request) {

        boolean errorFlag = false;
        boolean nameError;
        boolean emailError;
        boolean commentError;

        if (name == null
                || name.equals("")
                || name.length() > 25) {
            errorFlag = true;
            nameError = true;
            request.setAttribute("nameError", nameError);
        }
        if (email == null
                || email.equals("")
                || !email.contains("@")
                || !email.contains(".")) {
            errorFlag = true;
            emailError = true;
            request.setAttribute("emailError", emailError);
        }
        if (comment == null || comment.equals("")) {
            errorFlag = true;
            commentError = true;
            request.setAttribute("commentError", commentError);
        }
        
        return errorFlag;
    }
}