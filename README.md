Spring Example Project [![Build Status](https://travis-ci.org/christian-draeger/spring-boot-ready.svg?branch=master)](https://travis-ci.org/christian-draeger/spring-boot-ready)
====

Prerequisites
----
* jdk installed
* vagrant installed
* docker installed
* ansible installed

About
----
This is an example Spring-Boot application that is already configured 
to support a lot of tools and plugins i like to use in my daily business.

Things that are configured already:
* [Actuator](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready)
	* adds health check, jms, metrics, loggers, dependencies, ... endpoints
* [Spring-Boot Admin UI](https://github.com/codecentric/spring-boot-admin/blob/master/README.md)
	* really nice UI on top of Actuator to monitor spring boot applications. for instance can set different log 
	levels at runtime, see health status of dependencies (e.g. database, hystrix, messaging queues), metrics, etc.
* [SwaggerUI](https://swagger.io/swagger-ui/)
	* adds a generated living documentation of your api endpoints that will be always up-to-date, 
	with "try out" functionality to make actual requests 
* deployment via [Ansible](https://www.ansible.com/)
	* deploys the application into a vagrant box for testing behaviour - ready to only adjust hosts and ssh config to 
	have a server ready deployment. including serverside installation of:
		* jdk
		* [netdata](https://github.com/firehol/netdata/blob/master/README.md)
			* netdata is a system for distributed real-time performance and health monitoring. 
			It provides unparalleled insights, in real-time, of everything happening on the system 
			it runs (including applications such as web and database servers), 
			using modern interactive web dashboards.
* shell script for dependency update checks
	* check for maven property updates
	* check for maven plugin updates
	* check for maven dependency updates
* test report visiualisation with [Allure](https://docs.qameta.io/allure/)
	* Allure Framework is a flexible lightweight multi-language test report tool that not only shows a very concise 	representation of what have been tested in a neat web report form, but allows everyone participating in the development 	process to extract maximum of useful information from everyday execution of tests.
	
How
----

#### Application

To start the application locally run:

	mvn spring-boot:run
	 
To build a docker image from the application run:

	 mvn clean package docker:build
	 


