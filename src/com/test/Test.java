/**
 * This class is used to demonstrate the use of Gagawa to generated HTML.
 * Also, 2 test cases have been written in this class to trigger asserts. 
 * @author Abdul Mudabir
 * @reference https://code.google.com/p/gagawa/source/browse/trunk/gagawa/examples/com/hp/gagawa/examples/TestProgram.java
 */

package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.A;
import com.hp.gagawa.java.elements.Br;
import com.hp.gagawa.java.elements.Comment;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Tr;

public class Test {

	public static void main(String[] args) {
		Document doc = new Document(DocumentType.XHTMLStrict);
		
		Comment c1 = new Comment("First comment\n");
		c1.appendChild(new Text("This is my first comment.\n"));
		doc.body.appendChild(c1);
		doc.body.setBgcolor("#FFFF99");
		
		/*
		 * the line below fires the 2nd assert documented. The setId() method in 'Div' class has been
		 * modified to trigger the assert
		 */
		Div d1 = new Div().setId("firstDiv");
		
		Div d2 = new Div().setCSSClass("classCSS");
		
		/* test a 'Div' element by calling its newly defined parameterized constructor
		 * which assigns a null value to its 'tag' variable instead of "div" 
		 */
		Div d3 = new Div(null);
		
		d1.appendChild(d2);
		d2.appendChild(new Text("Inside Div2"));
		d2.appendChild(new Br());
		d2.appendChild(new Br());
		d2.appendChild(new A("http://www.google.com", "_blank").appendChild(new Text("Search with Google")));
		d2.appendChild(new Br());
		d2.appendChild(new Br());
		doc.body.appendChild(d1);
		
		// add 'Div3' to HTML 'body'
		doc.body.appendChild(d3);
		
		 Table table = new Table();
         
         int count = 0;
         for(int row = 0; row < 10; row++){
                 Tr tr = new Tr();
                 table.appendChild(tr);
                 for(int col = 0; col < 10; col++){
                         Td td = new Td();
                         tr.appendChild(td);
                         td.appendChild(new Text(count++));
                 }
         }
         doc.body.appendChild(table);
         
         d1.setStyle("float:center");
         
         try {
        	 File output = new File("C:\\Users\\abdul\\Desktop\\test.html");
        	 PrintWriter out = new PrintWriter(new FileOutputStream(output));
        	 out.println(doc.write());
        	 System.out.println(doc.write());
        	 out.close();
         } catch (FileNotFoundException e) {
        	 e.printStackTrace();
         }
		
	}

}
