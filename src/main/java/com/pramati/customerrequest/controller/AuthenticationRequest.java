package com.pramati.customerrequest.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5168255338143636930L;
	private String username;
    private String password;
}
