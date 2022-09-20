package co.uk.skills.service;

import co.uk.skills.entity.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {
    Skill addSkill(Skill skill);
    Skill updateSkill(Skill skill);
    List<Skill> getAll();
    List<Skill> getAllSkillsByCustomerId(long customerId);
    String delete(long skillId);
    String deleteAllSkillsByCustomerId(long customerId);
}
