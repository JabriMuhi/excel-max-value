package org.jabrimuhi.excelmaxvalue;

import org.jabrimuhi.excelmaxvalue.service.AppService;
import org.jabrimuhi.excelmaxvalue.tools.QuickSelect;
import org.jabrimuhi.excelmaxvalue.tools.ReadXLSX;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.jabrimuhi.excelmaxvalue.tools.QuickSelect.quickSelect;
import static org.jabrimuhi.excelmaxvalue.tools.ReadXLSX.loadDataFromExcel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;

class AppServiceTest {

    private AppService appService;

    @BeforeEach
    void setUp() {
        appService = new AppService();
    }

    @Test
    void testGetTopNMaxValue_ValidInput() throws Exception {
        String filePath = "test.xlsx";
        int topNValue = 3;
        List<Integer> mockValues = Arrays.asList(10, 20, 30, 40, 50);

        try (MockedStatic<ReadXLSX> readXLSXMockedStatic = mockStatic(ReadXLSX.class);
             MockedStatic<QuickSelect> quickSelectMockedStatic = mockStatic(QuickSelect.class)) {

            readXLSXMockedStatic.when(() -> loadDataFromExcel(filePath)).thenReturn(mockValues);
            quickSelectMockedStatic.when(() -> quickSelect(mockValues, 0, mockValues.size() - 1, mockValues.size() - topNValue))
                    .thenReturn(30);

            Integer result = appService.getTopNMaxValue(filePath, topNValue);

            assertEquals(30, result);
        }
    }

    @Test
    void testGetTopNMaxValue_InvalidTopNValue() {
        String filePath = "test.xlsx";
        Integer topNValue = 0;

        try (MockedStatic<ReadXLSX> readXLSXMockedStatic = mockStatic(ReadXLSX.class)) {
            readXLSXMockedStatic.when(() -> loadDataFromExcel(filePath))
                    .thenReturn(List.of(10, 20, 30));

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                appService.getTopNMaxValue(filePath, topNValue);
            });

            String expectedMessage = "invalid n value " + topNValue;
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    void testGetTopNMaxValue_TopNValueGreaterThanListSize() throws Exception {
        String filePath = "test.xlsx";
        Integer topNValue = 10;
        List<Integer> mockValues = Arrays.asList(10, 20, 30);

        try (MockedStatic<ReadXLSX> readXLSXMockedStatic = mockStatic(ReadXLSX.class)) {

            readXLSXMockedStatic.when(() -> loadDataFromExcel(filePath)).thenReturn(mockValues);

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                appService.getTopNMaxValue(filePath, topNValue);
            });

            String expectedMessage = "invalid n value " + topNValue;
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }
    }
}
