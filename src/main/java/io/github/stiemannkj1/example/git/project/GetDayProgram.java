/*
 * Copyright (c) 2016 Kyle Stiemann
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.stiemannkj1.example.git.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author Kyle Stiemann
 */
public class GetDayProgram {

    public static void main(String[] args) {

        String dateString = null;
        String datePattern = null;

        for (int i = 0; i < args.length; i++) {
            if (dateString != null && datePattern != null) {
                System.out.println("Warning: date string and pattern already set. Ignoring arguments after " +
                        args[i - 1]);
                break;
            }

            switch (args[i]) {
                case "--pattern":
                    // fall through:
                case "-p":
                    i++;
                    datePattern = args[i];
                break;
                default:
                    if (dateString == null) {
                        dateString = args[i];
                    }
                break;
            }
        }

        if (datePattern == null) {
            datePattern = "yyyy-MM-dd";
        }

        if (dateString == null) {
            System.err.println("Error: get-day requires a date string argument of the format: " + datePattern);
            System.exit(1);
        }

        try {
            LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern(datePattern));
            System.out.println(date.getDayOfWeek());
        } catch (DateTimeParseException e) {
            System.err.println("Error: date string must be of the format: " + datePattern);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: invalid date pattern. " + e.getMessage());
        } finally {
            System.exit(1);
        }

        System.exit(0);
    }
}
