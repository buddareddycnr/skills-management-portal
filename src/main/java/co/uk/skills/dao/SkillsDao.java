package co.uk.skills.dao;

import co.uk.skills.entity.Customer;
import co.uk.skills.entity.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillsDao {
    Skill saveSkill(Skill skill);
    List<Skill> getAll();
    List<Skill> getSkillsByCustomerId(long customerId);
    String deleteSkill(long skillId);
    String deleteAllSkillsByCustomerId(long customerId);
    Skill updateSkill(Skill skill);
}
