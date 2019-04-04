<%--
    Document   : cart
    Created on : May 20, 2010, 12:20:12 AM
    Author     : mirko
--%>

<%-- Postavi session-scoped varijablu da prati sa koje strane dolazi posetilac. To se koristi zbog mehanizma izbora jezika
     u Controlleru kako bi korisnik ostao na istoj strani kad izabere jezik izmedju Srpskog i Engleskog--%>

<c:set var='view' value='/cart' scope='session' />

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-48789068-2', 'auto');
  ga('send', 'pageview');

</script>

<div id="singleColumn">
    <c:choose>
        <c:when test="${cart.numberOfItems > 1}">
            <p><fmt:message key="yourCartContains"/> ${cart.numberOfItems} <fmt:message key="items"/>.</p>
        </c:when>
        <c:when test="${cart.numberOfItems == 1}">
            <p><fmt:message key="yourCartContains"/> ${cart.numberOfItems} <fmt:message key="item"/>.</p>
        </c:when>
        <c:otherwise>
            <p><fmt:message key="yourCartEmpty"/></p>
        </c:otherwise>
    </c:choose>            
    <div id="actionBar">
        <%-- clear cart widget --%>
        <c:if test="${!empty cart && cart.numberOfItems != 0}">

            <c:url var="url" value="viewCart">
                <c:param name="clear" value="true"/>
            </c:url>

            <a href="${url}" class="bubble hMargin"><fmt:message key="clearCart"/></a>
        </c:if>

        <%-- continue shopping widget --%>
        <c:set var="value">
            <c:choose>
                <%-- if 'selectedCategory' session object exists, send user to previously viewed category --%>
                <c:when test="${!empty listaArtikalaNaStrani}">
                    category
                </c:when>
                <%-- otherwise send user to welcome page --%>
                <c:otherwise>
                    index.jsp
                </c:otherwise>
            </c:choose>
        </c:set>

        <c:url var="url" value="${value}"/>
        <a href="${url}" class="bubble hMargin"><fmt:message key="continueShopping"/></a>

        <%-- checkout widget --%>
        <c:if test="${!empty cart && cart.numberOfItems != 0}">
            <a href="<c:url value='checkout'/>" class="bubble hMargin"><fmt:message key="proceedCheckout"/></a>
        </c:if>
    </div>

    <c:if test="${!empty cart && cart.numberOfItems != 0}">

        <h4 id="subtotal"><fmt:message key="subtotal"/>: &euro; <fmt:formatNumber value="${cart.subtotal}" pattern="0.00"/></h4>

        <table id="cartTable">

            <tr class="header">
                <th><fmt:message key="product"/></th>
                <th><fmt:message key="sifra"/></th>
                <th><fmt:message key="name"/></th>
                <th><fmt:message key="price"/></th>
                <th><fmt:message key="onStocks"/></th>
                <th><fmt:message key="quantity"/></th>
                <th><fmt:message key="removeItem"/></th>
            </tr>

            <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">

                <c:set var="product" value="${cartItem.product}"/>

                <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                    <td>
                        <img src="${initParam.productImagePath}/products/zupcanik2.png"
                             alt="${product.naziv}">
                    </td>
                    
                    <td>${product.sifra}</td>
                    
                    <td>${product.naziv}</td>

                    <td style="max-width: 80px;">
                        &euro; <fmt:formatNumber value="${cartItem.total}" pattern="0.00"/>
<!--                            <br>-->
<!--                            <span class="smallText">( &euro; ${product.cena} / <fmt:message key="unit"/> )</span>-->
                    </td>

                    <td style="max-width: 60px;">
                        ${product.naLageru} 
                    </td>

                    <td class="plaviButton">
                        <form action="<c:url value='updateCart'/>" method="post">
                            <input type="hidden"
                                   name="productId"
                                   value="${product.id}">
                            
                            <input type="text"
                                   maxlength="2"
                                   size="2"
                                   value="${cartItem.quantity}"
                                   name="quantity"
                                   style="margin:5px">
                            <input 
                                   type="submit"
                                   name="submit"
                                   value="<fmt:message key="update"/>">
                        </form>
                    </td>
                    <td style="max-width: 60px;">
                        <form action="<c:url value='updateCartRemoveItem'/>" method="post">
                            <input type="hidden"
                                   name="productIdRemove"
                                   value="${product.id}">
                            <input type="image"
                                   src="${initParam.productImagePath}/clearButton2.png"
                                   name="submitRemove"
                                   alt="submit">
                        </form>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </c:if>
</div>