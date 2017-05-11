package com.raworkstudio.codewars.breadcrumb_generator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class BreadcrumbGeneratorTests {


    private BreadcrumbGenerator generator = new BreadcrumbGenerator();


    private String[] seps = new String[] {" : ", " / ", " * ", " > ", " + "};

    private String[] answers = new String[] {
            "<a href=\"/\">HOME</a> : <a href=\"/pictures/\">PICTURES</a> : <span class=\"active\">HOLIDAYS</span>",
            "<a href=\"/\">HOME</a> / <a href=\"/users/\">USERS</a> / <span class=\"active\">GIACOMOSORBI</span>",
            "<a href=\"/\">HOME</a> * <span class=\"active\">DOCS</span>",
            "<a href=\"/\">HOME</a> > <a href=\"/very-long-url-to-make-a-silly-yet-meaningful-example/\">VLUMSYME</a> > <span class=\"active\">EXAMPLE</span>",
            "<a href=\"/\">HOME</a> + <a href=\"/users/\">USERS</a> + <span class=\"active\">GIACOMO SORBI</span>"};

    @Test
    public void simple_url_separated_by_colon_test() {
        String urls = "http://mysite.com/pictures/holidays.html";
        String actual = generator.generate_bc(urls, seps[0]);

        assertEquals("Simple URL", answers[0], actual);
    }

    @Test
    public void simple_url_with_parameters_separated_by_slash_test() {
        String urls = "www.codewars.com/users/GiacomoSorbi?ref=CodeWars";
        String actual = generator.generate_bc(urls, seps[1]);

        assertEquals("Simple URL with parameters", answers[1], actual);
    }

    @Test
    public void complex_url_with_index_and_anchor_separated_by_asterisk_test() {
        String urls = "www.microsoft.com/docs/index.htm#top";
        String actual = generator.generate_bc(urls, seps[2]);

        assertEquals("Simple URL with index an anchor", answers[2], actual);
    }

    @Test
    public void long_url_separated_by_diamond_test() {
        String urls = "mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.asp";
        String actual = generator.generate_bc(urls, seps[3]);

        assertEquals("Simple URL with index an anchor", answers[3], actual);
    }

    @Test
    public void long_url_separated_by_plus_test() {
        String urls = "www.very-long-site_name-to-make-a-silly-yet-meaningful-example.com/users/giacomo-sorbi";
        String actual = generator.generate_bc(urls, seps[3]);

        assertEquals("Simple URL with index an anchor", answers[3], actual);
    }

}


