package com.example.demo.controller;

import com.example.demo.dto.DeleteResponseDTO;
import com.example.demo.dto.GetResponseDTO;
import com.example.demo.dto.PostResponseDTO;
import com.example.demo.dto.PutResponseDTO;
import org.springframework.http.ResponseEntity;

/**
 * TestController is for testing purposes.
 */
public interface TestController {
    ResponseEntity<GetResponseDTO> getMethod(String requestParam);

    ResponseEntity<PostResponseDTO> postMethod(String requestHeaderParam);

    ResponseEntity<PutResponseDTO> putMethod(Object requestBody);

    ResponseEntity<DeleteResponseDTO> delete(String pathVariable);
}
