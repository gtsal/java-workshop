package com.intracom.ems.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@SuppressWarnings("serial")
public class HelpServlet extends HttpServlet {
    private static final String PARTICIPANT_FIELD = "participant";
    private static final String WORKSHOP_FIELD = "workshop";
    private static final String YEAR_FIELD = "year";
    private static final String WORKSHOP_VALUE = "Java SE/EE Workshop";
    private static final int YEAR_VALUE = 2017;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        String acceptHeader = req.getHeader("Accept").toLowerCase();
        BufferedReader br = null;
        String participantName = null;
        try {
            br = req.getReader();
            participantName = IOUtils.toString(br);
        } catch (IOException exc) {
            resp.setStatus(500);
            return;
        }
        if(participantName.split(" ").length < 2) {
            try {
                resp.setContentType("text/plain; charset=UTF-8");
                resp.setStatus(WorkshopToolkit.ERROR_CODE);
                resp.getWriter().print("Please provide your Full Name");
            } catch (IOException e) {
                resp.setStatus(500);
            }
            return;
        }
        switch (acceptHeader) {
        case "application/json":
            createResponseAsJson(participantName, resp);
            break;
        default:
            PrintWriter pw = null;
            /* 3rd Exercise: Create your First Servlet.
             * Write your code for first exercise here.
             * The response should carry the following string:
             * Participant: THE NAME OF Participant
             * Workshop: Java SE/EE Workshop
             * Year: 2017
             */
        }
    }

    private void createResponseAsJson(
            String participantName, HttpServletResponse resp) {
        /*
         * 5th Exercise: Send response in JSON format
         * Write code that will  the JSON string containing all
         * properties: "participant", "workshop", and "year".
         * 
         */
        throw new RuntimeException("Not Implemented");
    }
}
