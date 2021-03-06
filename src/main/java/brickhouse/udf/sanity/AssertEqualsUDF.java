package brickhouse.udf.sanity;
/**
 * Copyright 2012 Klout, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.log4j.Logger;

public class AssertEqualsUDF extends UDF {
	private static final Logger LOG = Logger.getLogger(AssertEqualsUDF.class);

	
	public String evaluate( Double val1, Double val2) {
		if( val1 == null || val2 == null ) {
			LOG.error(" Null values found :: " + val1 + " == " + val2);
			System.err.println(" Null values found :: " + val1 + " == " + val2);
			throw new RuntimeException(" Null values found :: " + val1 + " == " + val2);
		}
		if( ! val1.equals(val2) ) {
			LOG.error(" Assertion Not Met :: ! ( " + val1 + " == " + val2 + " ) ");
			System.err.println(" Assertion Not Met :: ! ( " + val1 + " == " + val2 + " ) ");
			throw new RuntimeException(" Assertion Not Met :: ! ( " + val1 + " == " + val2 + " ) ");
		} else {
			return val1.toString() + " == " + val2.toString();
		}
	}
}
