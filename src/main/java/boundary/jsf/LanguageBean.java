package boundary.jsf;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name="language")
@SessionScoped
public class LanguageBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String localeCode;

	private static Map<String,Object> countries;
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("ENG", Locale.ENGLISH); //label, value
		countries.put("NL", Locale.UK);
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}


	public String getLocaleCode() {
		return localeCode;
	}


	public void setLocaleCode(String localeCode) {
           
		this.localeCode = localeCode;
	}

	//value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e){

		String newLocaleValue = e.getNewValue().toString();
                System.out.println(newLocaleValue);
		//loop country map to compare the locale code
                for (Map.Entry<String, Object> entry : countries.entrySet()) {

        	   if(entry.getValue().toString().equals(newLocaleValue)){

        		FacesContext.getCurrentInstance()
        			.getViewRoot().setLocale((Locale)entry.getValue());

        	  }
               }
                System.out.println(FacesContext.getCurrentInstance().getViewRoot().getLocale());
	}

}