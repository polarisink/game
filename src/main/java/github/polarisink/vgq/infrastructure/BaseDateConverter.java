package github.polarisink.vgq.infrastructure;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static github.polarisink.vgq.infrastructure.utils.TimeUtil.*;

/**
 * @Author gmd
 * @Description EasyExcel自定义LocalDateTime系列时间日期转换器
 * 用法：
 * 1、@ExcelProperty(value = {"添加时间"}, converter = BaseDateConverter.LocalDateTimeConverter.class)
 * 2、ExcelWriter writer = EasyExcel.write(response.getOutputStream()).registerConverter(new BaseDateConverter.LocalDateConverter()).build();
 * @Date 2022-08-31 19:23:08
 */
public class BaseDateConverter {

  /**
   * 核心抽象类，负责不同类的数据类型装换
   *
   * @param <T> LocalXXX类泛型
   */
  private static abstract class CoreConverter<T> implements Converter<T> {

    private Class<T> clazz;

    /**
     * 指定Class类型，接收LocalDate.class，LocalTime.class，LocalDateTime.class
     */
    public CoreConverter(Class<T> clazz) {
      this.clazz = clazz;
    }

    /**
     * 导入支持的数据类型
     */
    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
      return CellDataTypeEnum.STRING;
    }

    /**
     * 导出支持的数据类型
     */
    @Override
    public Class supportJavaTypeKey() {
      return clazz;
    }

    /**
     * 导入时，数据类型转换
     *
     * @param cellData excel单元格数据
     * @param property 单元格样式
     * @param config   全局配置
     * @return
     */
    @Override
    public T convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty property, GlobalConfiguration config) throws Exception {
      // LocalDate日期转换
      if (cellData.getData() instanceof LocalDate) {
        return (T) LocalDate.parse(cellData.getStringValue(), DAY_F);
        // LocalTime时间转换
      } else if (cellData.getData() instanceof LocalTime) {
        return (T) LocalTime.parse(cellData.getStringValue(), TIME_F);
        // LocalDateTime时间日期转换
      } else if (cellData.getData() instanceof LocalDateTime) {
        return (T) LocalDateTime.parse(cellData.getStringValue(), SF);
      }
      return null;
    }

    /**
     * 导出时，数据类型转换
     *
     * @param obj      当前数据
     * @param property 单元格样式
     * @param config   全局配置
     * @return
     */
    @Override
    public WriteCellData<?> convertToExcelData(T obj, ExcelContentProperty property, GlobalConfiguration config) throws Exception {
      // LocalDate日期转换
      if (obj instanceof LocalDate) {
        return new WriteCellData<>(((LocalDate) obj).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        // LocalTime时间转换
      } else if (obj instanceof LocalTime) {
        return new WriteCellData<>(((LocalTime) obj).format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        // LocalDateTime时间日期转换
      } else if (obj instanceof LocalDateTime) {
        return new WriteCellData<>(((LocalDateTime) obj).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      }

      return new WriteCellData<>(obj.toString());
    }
  }

  /**
   * LocalDate数据类型转换器
   */
  public static class LocalDateConverter extends CoreConverter<LocalDate> {
    public LocalDateConverter() {
      super(LocalDate.class);
    }
  }

  /**
   * LocalTime数据类型转换器
   */
  public static class LocalTimeConverter extends CoreConverter<LocalTime> {
    public LocalTimeConverter() {
      super(LocalTime.class);
    }
  }

  /**
   * LocalDateTime数据类型转换器
   */
  public static class LocalDateTimeConverter extends CoreConverter<LocalDateTime> {
    public LocalDateTimeConverter() {
      super(LocalDateTime.class);
    }
  }

}