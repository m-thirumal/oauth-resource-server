/**
 * 
 */
package in.thirumal.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Thirumal
 *
 */
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@ToString@Builder
public class Order implements Serializable {

	private static final long serialVersionUID = -3496815994702273952L;

	private int id;
	private OffsetDateTime orderDate;
	private String itemName;
}
