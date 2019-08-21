package rest.models.petModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Accessors(chain = true)
public class PetModel {

	@JsonProperty("photoUrls")
	private List<String> photoUrls;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("category")
	private CategoryModel category;

	@JsonProperty("tags")
	private List<TagsItemModel> tags;

	@JsonProperty("status")
	private String status;

	@Override
	public boolean equals(Object o) {
		boolean rezult;
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PetModel petModel = (PetModel) o;
		rezult = id == petModel.getId() &&
				name.equals(petModel.getName()) &&
				category.equals(petModel.getCategory()) &&
				photoUrls.equals(petModel.getPhotoUrls()) &&
				tags.equals(petModel.getTags()) &&
				status.equals(petModel.getStatus())
		;
		return rezult;
	}
}