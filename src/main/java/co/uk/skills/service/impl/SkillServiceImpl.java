package co.uk.skills.service.impl;

import co.uk.skills.dao.SkillsDao;
import co.uk.skills.entity.Skill;
import co.uk.skills.exception.MandatoryFieldMissingException;
import co.uk.skills.service.SkillService;
import co.uk.skills.util.MandatoryFieldsLengthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {
    private SkillsDao skillsDao;
    private MandatoryFieldsLengthValidator<Skill> mandatoryFieldsLengthValidator;

    @Autowired
    public SkillServiceImpl(SkillsDao skillsDao, MandatoryFieldsLengthValidator<Skill> mandatoryFieldsLengthValidator) {
        this.skillsDao = skillsDao;
        this.mandatoryFieldsLengthValidator = mandatoryFieldsLengthValidator;

    }

    /**
     * @param skill
     * @return
     */
    @Override
    public Skill addSkill(Skill skill) {
        if (mandatoryFieldsLengthValidator.isValidInput(skill)){
            return skillsDao.saveSkill(skill);
        }else {
            throw new MandatoryFieldMissingException("Mandatory fields are missed or invalid length");
        }
    }
    /**
     * @param skill
     * @return
     */
    @Override
    public Skill updateSkill(Skill skill) {
        if (mandatoryFieldsLengthValidator.isValidInput(skill)){
            return skillsDao.updateSkill(skill);
        }else {
            throw new MandatoryFieldMissingException("Mandatory fields are missed or invalid length");
        }
    }

    /**
     * @return
     */
    @Override
    public List<Skill> getAll() {
        return skillsDao.getAll();
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public List<Skill> getAllSkillsByCustomerId(long customerId) {
        if (mandatoryFieldsLengthValidator.isValidLong(customerId)) {
            return skillsDao.getSkillsByCustomerId(customerId);
        }else {
            throw new MandatoryFieldMissingException("Invalid customer id passed to get the skills details");
        }
    }

    /**
     * @param skillId
     * @return
     */
    @Override
    public String delete(long skillId) {
        if (mandatoryFieldsLengthValidator.isValidLong(skillId)) {
            return skillsDao.deleteSkill(skillId);
        }else {
            throw new MandatoryFieldMissingException("Invalid skill id passed to delete the skills details");
        }
    }

    /**
     * @param customerId
     * @return
     */
    @Override
    public String deleteAllSkillsByCustomerId(long customerId) {
        if (mandatoryFieldsLengthValidator.isValidLong(customerId)) {
            return skillsDao.deleteAllSkillsByCustomerId(customerId);
        }else {
            throw new MandatoryFieldMissingException("Invalid customer id passed to delete the skills details");
        }
    }
}
