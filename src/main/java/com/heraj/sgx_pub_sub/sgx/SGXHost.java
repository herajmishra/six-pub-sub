package com.heraj.sgx_pub_sub.sgx;

import org.springframework.stereotype.Component;

@Component
public class SGXHost {
    static {
        System.loadLibrary("sgx_enclave"); // Load the SGX enclave library
    }

    public native String encrypt(String plaintext);

    public native String decrypt(String ciphertext);
}

