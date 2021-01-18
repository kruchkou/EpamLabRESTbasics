package com.epam.esm.dao;

import com.epam.esm.model.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagDAO {

    /**
     * Connects to database and deletes Tag with provided ID
     *
     * @param id is Tag ID value.
     */
    void deleteTag(int id);

    /**
     * Connects to database and add an new Tag.
     *
     * @param name is Tag name value
     * @return Created {@link Tag} entity from database
     */
    Tag createTag(String name);


    /**
     * Connects to database and returns Tag by ID.
     *
     * @param id is Tag ID value.
     * @return Optional of {@link Tag} entity from database.
     */
    Optional<Tag> getTagByID(int id);

    /**
     * Connects to database and returns all Tags.
     *
     * @return List of all {@link Tag} entities from database.
     */
    List<Tag> getTags();

    /**
     * Connects to database and returns Tag by name.
     *
     * @param name is Tag name value.
     * @return Optional of {@link Tag} entity from database.
     */
    Optional<Tag> getTagByName(String name);

    /**
     * Connects to database and returns list of Tags linked to GiftCertificate in gift_tag table
     *
     * @param id is GiftCertificate
     * @return List of matched {@link Tag} entities from database.
     */
    List<Tag> getTagListByGiftCertificateID(int id);

}
