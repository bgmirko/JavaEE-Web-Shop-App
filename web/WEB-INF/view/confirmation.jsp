<%--
    Document   : confirmation
    Created on : Sep 9, 2009, 12:20:30 AM
    Author     : mirko
--%>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-48789068-2', 'auto');
  ga('send', 'pageview');

</script>

<div id="singleColumn">

    <p id="confirmationText">
        <strong><fmt:message key="successMessage"/></strong>
        <br><br>
        <fmt:message key="confirmationNumberMessage"/>
        <strong>${orderRecord.komentar}</strong> 
        <br>
        <fmt:message key="contactMessage"/>
        <br><br>
        <fmt:message key="thankYouMessage"/>
    </p>

    <div class="summaryColumn" >

        <table id="orderSummaryTable" class="detailsTable">
            
            <tr class="header">
                <th colspan="3"><fmt:message key="orderSummary"/></th>
            </tr>

            <tr class="tableHeading">
                <td><fmt:message key="product"/></td>
                <td><fmt:message key="quantity"/></td>
                <td><fmt:message key="price"/></td>
            </tr>

            <c:forEach var="orderedProduct" items="${orderedProducts}" varStatus="iter">

                <tr class="${((iter.index % 2) != 0) ? 'lightBlue' : 'white'}">
                    <td>${products[iter.index].naziv}</td>
                    <td class="quantityColumn">
                        ${orderedProduct.kolicina}
                    </td>
                    <td class="confirmationPriceColumn">
                        &euro; <fmt:formatNumber value="${products[iter.index].cena * orderedProduct.kolicina}" pattern="0.00"/>
                    </td>
                </tr>

            </c:forEach>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

          

            <tr class="lightBlue">
                <td colspan="2" id="totalCellLeft"><strong><fmt:message key="total"/>:</strong></td>
                <td id="totalCellRight">&euro; <fmt:formatNumber value="${orderRecord.vrednost}" pattern="0.00"/></td>
            </tr>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="3" id="dateProcessedRow"><strong><fmt:message key="dateProcessed"/></strong>
                    <br>
                    ${orderRecord.datum}
                </td>
            </tr>
        </table>

    </div>

    <div class="summaryColumn" >

        <table id="deliveryAddressTable" class="detailsTable">
            <tr class="header">
                <th colspan="3"><fmt:message key="deliveryAddress"/></th>
            </tr>

            <tr>
                <td colspan="3" class="lightBlue">
                    ${customer.osoba}
                    <br>
                    ${customer.adresa}
                    <br>
                    ${customer.grad}
                    <br>
                    ${customer.drzava}
                    <br>
                    <hr>
                    <strong>email:</strong> ${customer.komentar}
                    <br>
                    <strong>phone:</strong> ${customer.tel1}
                </td>
            </tr>
        </table>
    </div>

  

</div>

