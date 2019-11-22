package org.extentreport;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class Sampvelocity {

	public static void main(String[] args) throws Exception {

		VelocityEngine ve = new VelocityEngine();
		ve.init();
		Template t = ve.getTemplate("Velo.vm");
		VelocityContext context = new VelocityContext();
				context.put("ExecutedResult", "NO");
				//context.put("TestResult", "pass");
				StringWriter writer = new StringWriter();
				t.merge(context, writer);
				System.out.println(writer.toString());
		
	}

}

	


