package org.rally.backend.userprofilearm.model.dto;

public class AuthResponseDTO {

    /** JWT Auth Filter Homework **/

    private String accessToken;
    private String tokenType = "Bearer ";

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }

}
