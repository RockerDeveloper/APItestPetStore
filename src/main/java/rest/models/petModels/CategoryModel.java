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
public class CategoryModel {

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
		CategoryModel categoryModel = (CategoryModel) o;
		rezult = id == categoryModel.getId() &&
				name.equals(categoryModel.getName());
		return rezult;
	}
}