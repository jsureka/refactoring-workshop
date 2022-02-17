package workshop;

import org.junit.Test;

import  org.junit.Assert;

public class HtmlPagesConverterIntegrationTest {
    @Test
    public void convertFromActualFile() throws Exception {
        PlaintextToHtmlConverter converter = new PlaintextToHtmlConverter();
        Assert.assertEquals("abc<br />&lt;hello&gt;", converter.toHtml());
    }
}
