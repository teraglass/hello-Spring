package ddit.di.xml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {
	@Value("Spring")
	private String name;
	
	@Autowired
	@Qualifier("stringPrinter")
	private Printer printer;
	
	//컬렉션 타입 DI -List
	private List<String> names;
	
	public void setNames(List<String> names) {
		this.names = names;
	}
	public List<String> getNames() {
		return names;
	}

	//생성자 DI
	public Hello() {}
	

	public Hello(String name, Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}
	
	//setter DI
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setPrinter(Printer printer) {
//		this.printer = printer;
//	}
	public String sayHello() {
		return "Hello " + name;
	}
	public void print() {
		this.printer.print(sayHello());
	}
	
}
