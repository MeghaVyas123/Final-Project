package com.javasampleapproach.springrest.mysql.model;
 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
 
@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Id may not be null")
    private int sId;

    @NotNull(message = "UserName may not be null")
    private String sUserName;

    @NotNull(message = "Password may not be null")
    private String sPassword;

   // @NotNull(message = "Email ID may not be null")
    private String sEmailId;

    @NotNull(message = "Company Name may not be null")
    private String sCompanyName;

    @NotNull(message = "Company Description may not be null")
    private String sCompanyDescription;

    @NotNull(message = "Role may not be null")
    private String sRole;
    
	public String getsRole() {
		return sRole;
	}

	public void setsRole(String sRole) {
		this.sRole = sRole;
	}

	
    public Seller() {}

    
    public Seller(@NotNull(message = "Id may not be null") int sId,
			@NotNull(message = "UserName may not be null") String sUserName,
			@NotNull(message = "Password may not be null") String sPassword,
			@NotNull(message = "Email ID may not be null") String sEmailId,
			@NotNull(message = "Company Name may not be null") String sCompanyName,
			@NotNull(message = "Company Description may not be null") String sCompanyDescription, String sRole) {
		super();
		this.sId = sId;
		this.sUserName = sUserName;
		this.sPassword = sPassword;
		this.sEmailId = sEmailId;
		this.sCompanyName = sCompanyName;
		this.sCompanyDescription = sCompanyDescription;
		this.sRole = sRole;
	}

	public int getsId() {
        return sId;
    }
    public void setsId(int sId) {
        this.sId = sId;
    }
    public String getsUserName() {
        return sUserName;
    }
    public void setsUserName(String sUserName) {
        this.sUserName = sUserName;
    }
    public String getsPassword() {
        return sPassword;
    }
    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }
    public String getsEmailId() {
        return sEmailId;
    }
    public void setsEmailId(String sEmailId) {
        this.sEmailId = sEmailId;
    }
    public String getsCompanyName() {
        return sCompanyName;
    }
    public void setsCompanyName(String sCompanyName) {
        this.sCompanyName = sCompanyName;
    }
    public String getsCompanyDescription() {
        return sCompanyDescription;
    }
    public void setsCompanyDescription(String sCompanyDescription) {
        this.sCompanyDescription = sCompanyDescription;
    }

	@Override
	public String toString() {
		return "Seller [sId=" + sId + ", sUserName=" + sUserName + ", sPassword=" + sPassword + ", sEmailId=" + sEmailId
				+ ", sCompanyName=" + sCompanyName + ", sCompanyDescription=" + sCompanyDescription + ", sRole=" + sRole
				+ "]";
	}
   
    

 
}