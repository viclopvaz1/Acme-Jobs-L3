
package acme.entities.challenges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	public static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@NotBlank
	private String				description;

	@NotBlank
	private String				goldGoal;

	@NotBlank
	private String				silverGoal;

	@NotBlank
	private String				bronzeGoal;

	@Valid
	private Money				goldReward;

	@Valid
	private Money				silverReward;

	@Valid
	private Money				bronzeReward;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;
}
