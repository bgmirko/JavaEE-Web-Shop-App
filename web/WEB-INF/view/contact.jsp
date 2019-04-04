<%-- 
    Document   : contact
    Created on : Mar 6, 2013, 11:33:04 AM
    Author     : Mirko
--%>

<c:set var='view' value='/contact' scope='session'/>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-48789068-2', 'auto');
  ga('send', 'pageview');

</script>

<h3 style="text-align: left; margin-left: 30px;"><fmt:message key="contactUs"/></h3>

<c:choose>
    <c:when test="${testMessageSent}">
        <p style="text-align: left; margin: 50px 0 50px 30px;">Your message was sent successfully</p>
        <c:set var="testMessageSent" value="false"/>
    </c:when> 
    <c:otherwise>
        <p style="margin-left: 30px; margin-right: 30px; text-align: left;"><fmt:message key="contactText"/></p>

        <form id="" action="<c:url value="/contact"/>" method="post">
            <table id="contactTable" border="0">
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
                                <c:if test="${!empty commentError}">
                                    <br><span class="indent"><fmt:message key="errorComment"/></span>
                                </c:if>
                            </span>
                        </td>
                    </tr>
                </c:if>
                <tbody>
                    <tr>
                        <td><label for="name"><fmt:message key="nameContact"/>:</label></td>
                        <td>
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
                        <td><label for="subject"><fmt:message key="subject"/>:</label></td>
                        <td class="inputField">
                            <input type="text"
                                   size="31"
                                   maxlength="16"
                                   id="phone"
                                   name="subject"
                                   value="${param.subject}">
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-top: 10px;"><fmt:message key="comment"/>:</td>
                        <td class="inputField" style="padding-top: 10px;">
                            <textarea id="commentTextArea" rows="10" cols="39" title="Comment" name="comment"  value="${param.comment}">${param.comment}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="plaviButton">                   
                            <input type="submit" style="margin-right: 20px;" value="<fmt:message key="submitComment"/>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">                             
                            <label for="required" class="required"><fmt:message key="required"/></label>
                        </td>
                    </tr>
                </tbody>       
            </table>
        </form>

    </c:otherwise>

</c:choose>

