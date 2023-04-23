package top.om1ga.common.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import top.om1ga.common.utils.DateUtils;
import java.util.Date;

/**
 * @author: mqxu
 * @version: 1.0
 * @Date: 2023年04月23日 19:11
 * @Description: 日期转换
 * @since: 1.0
 */
public class DateConverter implements Converter<Date> {

    @Override
    public Class<Date> supportJavaTypeKey() {
        return Date.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Date convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        String dateString = cellData.getStringValue();
        return dateString == null ? null : DateUtils.parse(dateString, DateUtils.DATE_TIME_PATTERN);
    }

    @Override
    public WriteCellData<Date> convertToExcelData(Date value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        String dateValue = DateUtils.format(value, DateUtils.DATE_TIME_PATTERN);
        return new WriteCellData<>(dateValue);
    }
}