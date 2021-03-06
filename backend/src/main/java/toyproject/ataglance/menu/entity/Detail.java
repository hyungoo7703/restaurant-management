package toyproject.ataglance.menu.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Table("ATAGLANCE_MENU_DETAIL")
@Getter
public class Detail implements Persistable<String>{
	
	@Id
	@Column("detail_id")
	private String id;
	@Column("detail_name")
	private String name;
	
	private int price;
	private String memo;
	
	@CreatedDate
	private LocalDateTime dateCreated;
	@LastModifiedDate
	private LocalDateTime dateUpdated;

	private boolean enabled;
	
	@Column("fk_theme_id")
	private String themeId;
	
	@JsonIgnore
	@Override
	public String getId() {
		return id;
	}
	@JsonIgnore
	@Override
	public boolean isNew() {
		return dateCreated == null;
	}
	
	protected Detail() {}
	
	public Detail(String id, String name, int price, String memo, boolean enabled, String themeId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.memo = memo;
		this.enabled = enabled;
		this.themeId = themeId;
	}
	
}
