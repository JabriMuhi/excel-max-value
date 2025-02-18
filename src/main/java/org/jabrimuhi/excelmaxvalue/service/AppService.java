package org.jabrimuhi.excelmaxvalue.service;

import org.springframework.stereotype.Service;

import java.util.List;

import static org.jabrimuhi.excelmaxvalue.tools.QuickSelect.quickSelect;
import static org.jabrimuhi.excelmaxvalue.tools.ReadXLSX.loadDataFromExcel;

@Service
public class AppService {
    public Integer getTopNMaxValue(String filePath, Integer topNValue) throws Exception {
        List<Integer> values = loadDataFromExcel(filePath);

        if (topNValue == null || topNValue <= 0 || topNValue > values.size()) {
            throw new IllegalArgumentException("invalid n value " + topNValue);
        }

        return quickSelect(values, 0, values.size() - 1, values.size() - topNValue);
    }
}
