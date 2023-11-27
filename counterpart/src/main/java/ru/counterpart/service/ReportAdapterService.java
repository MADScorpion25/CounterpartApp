package ru.counterpart.service;

import org.springframework.stereotype.Service;

@Service
public class ReportAdapterService extends AbstractFeignAdapter {

    public byte[] getReport() {
        return sendGetRequest(byte[].class);
    }
}
