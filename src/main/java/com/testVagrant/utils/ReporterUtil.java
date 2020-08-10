package com.testVagrant.utils;

import io.qameta.allure.Step;
import org.testng.Reporter;

public class ReporterUtil {

	@Step("{0}")
	public static void log(String str) {
		Reporter.log(str, true);
	}

	public static void err(String str) {
		System.out.println("ERR: " + str);
	}

	public static void fail(String str) {
		System.out.println("FAILED: " + str);
	}

	public static void reportTC(String tcName, String msg) {

		log("=====================================================================");
		log(String.format(" Test: %s Status: %s", tcName, msg));
		log("=====================================================================");
	}

}
