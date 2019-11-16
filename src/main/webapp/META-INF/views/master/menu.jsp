<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>

		<%--josruialb--%>
		<%--viclopvaz1--%>
		<%--albcorare26--%>
		<%--dansangar2--%>

		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.shout" action="/anonymous/shout/create" />
			<acme:menu-suboption code="master.menu.anonymous.list-shout" action="/anonymous/shout/list" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-announcement" action="/anonymous/announcement/list" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-company-record" action="/anonymous/company-record/list" />
			<acme:menu-suboption code="master.menu.anonymous.listtop-company-record" action="/anonymous/company-record/stars" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-investor-record" action="/anonymous/investor-record/list" />
			<acme:menu-suboption code="master.menu.anonymous.listtop-investor-record" action="/anonymous/investor-record/stars" />


			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-comercial-banner" action="/anonymous/comercial-banner/list" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-non-comercial-banner" action="/anonymous/non-comercial-banner/list" />


		</acme:menu-option>

		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.request.list-request" action="/authenticated/request/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.offer.list-offer" action="/authenticated/offer/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.list-announcement" action="/authenticated/announcement/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.list-company-record" action="/authenticated/company-record/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.list-investor-record" action="/authenticated/investor-record/list" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.authenticated.list-challenge" action="/authenticated/challenge/list" />
			<acme:menu-separator />

		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown" />
			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.administrator.configuration" action="/administrator/configuration/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.estadistica" action="/administrator/estadistica/list" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.announcement" action="/administrator/announcement/create" />
			<acme:menu-suboption code="master.menu.administrator.list-announcement" action="/administrator/announcement/list" />


			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.list-investor-record" action="/administrator/investor-record/list" />
			<acme:menu-suboption code="master.menu.administrator.create-investor-record" action="/administrator/investor-record/create" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.list-company-record" action="/administrator/company-record/list" />
			<acme:menu-suboption code="master.menu.administrator.create-company-record" action="/administrator/company-record/create" />

			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.list-challenge" action="/administrator/challenge/list" />
			<acme:menu-suboption code="master.menu.administrator.challenge" action="/administrator/challenge/create" />
			

			<acme:menu-separator />

			<acme:menu-suboption code="master.menu.administrator.list-non-comercial-banner" action="/administrator/non-comercial-banner/list" />
			<acme:menu-suboption code="master.menu.administrator.create-non-comercial-banner"
				action="/administrator/non-comercial-banner/create" />
			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.list-comercial-banner" action="/administrator/comercial-banner/list"/>
			<acme:menu-suboption code="master.menu.administrator.comercial-banner" action="/administrator/comercial-banner/create" />

		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.create-offer" action="/consumer/offer/create" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.create-request" action="/provider/request/create" />
		</acme:menu-option>

	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update" />

			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create"
				access="!hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update"
				access="hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create"
				access="!hasRole('Consumer')" />
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update"
				access="hasRole('Consumer')" />


		</acme:menu-option>







		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()" />

	</acme:menu-right>
</acme:menu-bar>

