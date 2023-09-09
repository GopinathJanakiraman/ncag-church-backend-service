package in.ncag.church.dto;

import org.springframework.stereotype.Component;

@Component
public class CapabilityOfUser
{
	private Boolean isUserCapability = false;
		
	public Boolean getIsUserCapability() {
		return isUserCapability;
	}

	public void setIsUserCapability(Boolean isUserCapability) {
		
		if(null !=isUserCapability)
		{
			this.isUserCapability = isUserCapability;
		}
	}
}