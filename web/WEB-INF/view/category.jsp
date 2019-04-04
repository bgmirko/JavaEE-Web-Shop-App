<%--
    Document   : category
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : mirko
--%>

<%-- Postavi session-scoped varijablu da prati sa koje strane dolazi posetilac. To se koristi zbog mehanizma izbora jezika
     u Controlleru kako bi korisnik ostao na istoj strani kad izabere jezik izmedju Srpskog i Engleskog--%>

<c:set var='view' value='/category' scope='session' />

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-48789068-2', 'auto');
  ga('send', 'pageview');

</script>

<%--<c:choose>    
    <c:catch var="e">
        <img src="${initParam.productImagePath}/products/${artikal.sifra}.png" alt="product image">
    </c:catch>
    <c:when test="${!empty e}">
        Error: ${e.message}
    </c:when>
    <c:otherwise>
        <img src="${initParam.productImagePath}/products/${artikal.sifra}.png" alt="product image">
    </c:otherwise>
</c:choose>--%>


<div id="categoryLeftColumn">

    <c:forEach var="artikal" items="${grupeArtikli}">
        <c:url var="url" value="/category" >
            <c:param value="${1}" name="strana"/>
            <c:param name="categoryId" value="${artikal.id}"/>
        </c:url>
        <c:choose>
            <c:when test="${artikal.naziv==selectedGrupaNaziv}">
                <div class="button" id="selectedCategory">
                    <span class="categoryText">
                        <fmt:message key="${artikal.naziv}"/>
                    </span>
                </div>
            </c:when>
            <c:otherwise>
                <a href="${url}" class="button">
                    <div>  
                        <fmt:message key="${artikal.naziv}"/>
                    </div>
                </a>
            </c:otherwise>
        </c:choose>
    </c:forEach>  
</div>


<div id="categoryRightColumn">
    <c:if test="${ukupnoStrana!=0}">
        <div id="navigator">
            <ul>
                <c:choose>
                    <c:when test="${strana!=1}">
                        <li class="biracStrana">
                            <c:url var="url" value="/category" >
                                <c:param value="${strana - 1}" name="strana"/>
                            </c:url>
                            <a href="${url}"><</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="biracStranaEmpty"></li>
                        </c:otherwise>
                    </c:choose>    

                <c:if test="${ukupnoStrana!=1}">         
                    <c:forEach var="i" begin="1" end="${ukupnoStrana}">  
                        <c:choose>
                            <c:when test="${strana!=i}">
                                <li class="biracStrana">
                                    <c:url var="url" value="/category" >
                                        <c:param value="${i}" name="strana"/>
                                    </c:url>
                                    <a href="${url}">${i}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="biracStrana biracStranaSelected">
                                    <c:url var="url" value="/category" >
                                        <c:param value="${i}" name="strana"/>
                                    </c:url>
                                    <a href="${url}">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:if>

                <c:choose>
                    <c:when test="${strana!=ukupnoStrana && fn:length(listaArtikalaNaStrani)!=0}">
                        <li class="biracStrana">
                            <c:url var="url" value="/category" >
                                <c:param value="${strana + 1}" name="strana"/>
                            </c:url>
                            <a href="${url}">></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="biracStranaEmpty"></li>
                        </c:otherwise>
                    </c:choose>    

            </ul>


        </div>
    </c:if>


    <p id="categoryTitle"><fmt:message key="${selectedGrupaNaziv}"/></p>

    <c:choose>
        <c:when test="${ukupnoStrana!=0}">
            <table id="productTable">

                <c:forEach var="artikal" items="${listaArtikalaNaStrani}" varStatus="iter">

                    <tr>                
                    <script type="text/javascript">
                        function loadImage(x)
                        {                         
                            var element="productImage" +x;
                            document.getElementById(element).src='img/products/no-photo.png';
                        }
                    </script>
                    
                        <td class="${((iter.index%2)==0)? 'lightBlue' : 'white'}">
                            <img id="productImage${iter.index}" src="${initParam.productImagePath}/products/${artikal.sifra}.png" alt="product image" onerror="loadImage(${iter.index})">
                        </td>

                        <td class="${((iter.index%2)==0)? 'lightBlue' : 'white'}">
                            ${artikal.sifra}
                        </td>              

                        <td class="${((iter.index%2)==0)? 'lightBlue' : 'white'} maxWidth">
                            ${artikal.naziv}
                            <br>
                            <span class="smallText">${artikal.komentar}</span>
                        </td>

                        <td class="${((iter.index%2)==0)? 'lightBlue' : 'white'}">
                            <c:choose>
                                <c:when test="${artikal.naLageru>0}">                          
                                    <p class="onStockParagraf"><fmt:message key="onStocks"/></p>
                                    ${artikal.naLageru}
                                </c:when>
                                <c:when test="${artikal.naLageru==0}">
                                    <p class="onStockParagraf" style="color: red;"><fmt:message key="outOfStocks"/></p>
                                </c:when>
                            </c:choose> 
                        </td>
                        <td class="${((iter.index%2)==0)? 'lightBlue' : 'white'}">&euro; ${artikal.cena}</td>

                        <td class="${((iter.index%2)==0)? 'lightBlue' : 'white'}" style="width: 155px;">
                            <c:if test="${artikal.naLageru>0}">
                                <form  action="<c:url value="/addToCart"/>" method="post" >
                                    <input type="hidden" 
                                           name="artikalId"
                                           value="${artikal.id}">
                                    <input class="addToCartButton"  
                                           type="submit" 
                                           name="submit"
                                           value="<fmt:message key="addToCart"/>">
                                </form>
                            </c:if>
                        </td>               
                    </tr>

                </c:forEach>

            </table>
        </c:when>
        <c:otherwise>
            <p style="margin: 50px 0 0 60px; float: left;"><fmt:message key="emptySearch"/></p>
        </c:otherwise>
    </c:choose>

</div>

