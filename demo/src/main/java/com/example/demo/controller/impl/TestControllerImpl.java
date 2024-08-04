package com.example.demo.controller.impl;

import com.example.demo.controller.TestController;
import com.example.demo.dto.DeleteResponseDTO;
import com.example.demo.dto.GetResponseDTO;
import com.example.demo.dto.PostResponseDTO;
import com.example.demo.dto.PutResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This is an implementation of TestController interface.
 * The sole purpose of this class is for testing purposes.
 * I am providing this basic implementation.
 * <p>
 * See curls_for_project.txt to see the curl examples.
 *
 * @author Boris Popic
 */
@RestController
@RequestMapping("/api/v1/test/")
public class TestControllerImpl implements TestController {

    @GetMapping("get")
    @CrossOrigin(origins = "*")
    @Override
    public ResponseEntity<GetResponseDTO> getMethod(@RequestParam(name = "demoRequestParam") String requestParam) {
        return ResponseEntity.ok(
                GetResponseDTO.builder()
                        .message("Demo request param: " + requestParam)
                        .build()
        );
    }

    @PostMapping("post")
    @CrossOrigin(origins = "*")
    @Override
    public ResponseEntity<PostResponseDTO> postMethod(@RequestHeader(name = "TestHeaderParam") String requestParam) {
        return ResponseEntity.ok(
                PostResponseDTO.builder()
                        .message("Test header parameter: " + requestParam)
                        .build()
        );
    }

    @PutMapping("put")
    @CrossOrigin(origins = "*")
    @Override
    public ResponseEntity<PutResponseDTO> putMethod(@RequestBody Object requestBody) {
        return ResponseEntity.ok(
                PutResponseDTO.builder()
                        .message("Request body " + requestBody)
                        .build()
        );
    }


    @DeleteMapping("delete/{testPathVar}/")
    @CrossOrigin(origins = "*")
    @Override
    public ResponseEntity<DeleteResponseDTO> delete(@PathVariable(name = "testPathVar") String pathVariable) {
        return ResponseEntity.ok(
                DeleteResponseDTO.builder()
                        .message("Test path variable: " + pathVariable)
                        .build()
        );
    }
}
