package com.personal.vrpapi.core.base;

import com.personal.vrpapi.core.base.initialdata.SampleData;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@RequiredArgsConstructor
public class InitialSampleDataSetup {
    private final List<SampleData> sampleDataList;

    @EventListener
    public void onApplicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {
        sampleDataList.forEach(SampleData::createData);
    }

}