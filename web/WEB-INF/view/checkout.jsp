<%-- Postavi session-scoped varijablu da prati sa koje strane dolazi posetilac. To se koristi zbog mehanizma izbora jezika
     u Controlleru kako bi korisnik ostao na istoj strani kad izabere jezik izmedju Srpskog i Engleskog--%>

<c:set var='view' value='/checkout' scope='session'/>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-48789068-2', 'auto');
  ga('send', 'pageview');

</script>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(document).ready(function() {
        $("#checkoutForm").validate({
            rules: {
                name: "required",
                email: {
                    required: true,
                    email: true
                },
                phone: {
                    number: true,
                    minlength: 9
                },
                address: {
                    required: true
                },
                city: {
                    required: true
                },
                country: {
                    required: true
                }
            }
        });
    });
</script>


<div id="singleColumn">

    <h2 style="font-size: 20px; margin-left: 20px;"><fmt:message key="checkout"/></h2>

    <p style="font-size: 16px; margin-left: 20px;"><fmt:message key="checkoutText"/></p>

    <form id="checkoutForm" action="<c:url value="/purchase"/>" method="post">
        <table id="checkoutTable" style="margin-top: 10px;">
            <c:if test="${!empty validationErrorFlag}">
                <tr>
                    <td colspan="2" style="text-align:left">
                        <span class="error smallText"><fmt:message key="errorGeneral"/>
                            <c:if test="${!empty nameError}">
                                <br><span class="indent"><fmt:message key="errorIme"/></span>
                            </c:if>
                            <c:if test="${!empty emailError}">
                                <br><span class="indent"><fmt:message key="errorEmail"/></span>
                            </c:if>
                            <c:if test="${!empty phoneError}">
                                <br><span class="indent"><fmt:message key="errorTelefon"/></span>
                            </c:if>
                            <c:if test="${!empty addressError}">
                                <br><span class="indent"><fmt:message key="errorAdresa"/></span>
                            </c:if>
                            <c:if test="${!empty cityError}">
                                <br><span class="indent"><fmt:message key="errorGrad"/></span>
                            </c:if>
                            <c:if test="${!empty countryError}">
                                <br><span class="indent"><fmt:message key="errorDrzava"/></span>
                            </c:if>
                        </span>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td><label for="name"><fmt:message key="customerName"/>:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="25"
                           id="name"
                           name="name"
                           value="${param.name}">
                </td>
            </tr>
            <tr>
                <td><label for="email"><fmt:message key="email"/>:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           value="${param.email}">
                </td>
            </tr>
            <tr>
                <td><label for="phone"><fmt:message key="phone"/>:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="phone"
                           name="phone"
                           value="${param.phone}">
                </td>
            </tr>
            <tr>
                <td><label for="address"><fmt:message key="address"/>:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="25"
                           id="address"
                           name="address"
                           value="${param.address}">
                </td>
            </tr>
            <tr>
                <td class="inputField"><label for="city"><fmt:message key="city"/>:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="15"
                           id="city"
                           name="city"
                           value="${param.city}">
                </td>
            </tr>
            <tr>
                <td><label for="country"><fmt:message key="country"/>:</label></td>
                <td>
                    <input type="text"
                           size="31"
                           maxlength="30"
                           id="country"
                           name="country"
                           value="${param.country}">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="plaviButton">                   
                    <input style="height: 22px; margin-top: 5px; margin-bottom: 0;" type="submit" value="<fmt:message key="submitPurchase"/>">
                </td>
            </tr>
            <tr>
                <td colspan="2">                             
                    <label for="required" class="required"><fmt:message key="required"/></label>
                </td>
            </tr>
        </table>
    </form>

</form>

<p style="float: left; font-size: 16px; margin: 20px 90px 0px 20px;"><fmt:message key="contactedByMail"/></p>


<div id="infoBox">
    <p style="margin-left: 25px;"><fmt:message key="shippingTerms"/></p>
    <ul>        
    
      
        <li><fmt:message key="freeShipping"/></li>
        <li><fmt:message key="prepayment"/></li>
    </ul>

    <table id="priceBox">
        <tr>
            <td><fmt:message key="subtotal"/>:</td>
            <td class="checkoutPriceColumn">
                &euro; <fmt:formatNumber value="${cart.subtotal}" pattern="0.00"/></td>
        </tr>
   <%--     <tr>
            <td><fmt:message key="surcharge"/>:</td>
            <td class="checkoutPriceColumn">
                &euro; <fmt:message key="deliverByMail"/> </td>
        </tr>
        <tr>
            <td class="total"><fmt:message key="total"/>:</td>
            <td class="total checkoutPriceColumn">
                &euro; <fmt:formatNumber value="${cart.total}" pattern="0.00"/></td>
        </tr>--%>
    </table>
</div>
</div>

