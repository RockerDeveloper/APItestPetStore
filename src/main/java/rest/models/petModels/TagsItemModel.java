package rest.models.petModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TagsItemModel {

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@Override
	public boolean equals(Object o) {
		boolean rezult;
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TagsItemModel tagsModel = (TagsItemModel) o;
		rezult = id == tagsModel.getId() &&
				name.equals(tagsModel.getName());
		return rezult;
	}
}