package homework.ultimatemall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Kind)表实体类
 *
 * @author makejava
 * @since 2022-12-04 22:12:34
 */
@SuppressWarnings("serial")
@Data
public class Kind extends Model<Kind> {

    private String itemKind;

}

