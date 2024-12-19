package com.fc.fullcycle.admin.catalog.application.category.update;

import com.fc.fullcycle.admin.catalog.application.update.DefaultUpdateCategoryUseCase;
import com.fc.fullcycle.admin.catalog.application.update.UpdateCategoryCommand;
import com.fc.fullcycle.admin.catalog.domain.category.Category;
import com.fc.fullcycle.admin.catalog.domain.category.CategoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;
import java.util.Optional;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UpdateCategoryUseCaseTest {

    @InjectMocks
    private DefaultUpdateCategoryUseCase useCase;

    @Mock
    private CategoryGateway categoryGateway;

    @Test
    public void givenAValidCommand_whenCallsUpdateCategory_shouldReturnCategoryId() {
        final var aCategory = Category.newCategory("Movie", null, true);

        final var expectedName = "Movies";
        final var expectedDescription = "The category most watch";
        final var expectedIsActive = true;

        final var expectedId = aCategory.getId();

        final var aCommand = UpdateCategoryCommand.with(expectedId.getValue(), expectedName, expectedDescription, expectedIsActive);

        Mockito.when(categoryGateway.findById(eq(expectedId)))
                .thenReturn(Optional.of(aCategory.clone()));
        Mockito.when(categoryGateway.update(any()))
                .thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(aCommand).get();

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.id());

        Mockito.verify(categoryGateway, Mockito.times(1)).findById(eq(expectedId));

        Mockito.verify(categoryGateway, Mockito.times(1)).update(argThat(
                aUpadateCategory ->
                        Objects.equals(expectedName, aUpadateCategory.getName())
                                && Objects.equals(expectedDescription, aUpadateCategory.getDescription())
                                && Objects.equals(expectedIsActive, aUpadateCategory.isActive())
                                && Objects.equals(expectedId, aUpadateCategory.getId())
                                && Objects.equals(aCategory.getCreatedAt(), aUpadateCategory.getCreatedAt())
                                && aCategory.getUpdatedAt().isBefore(aUpadateCategory.getUpdatedAt())
                                && Objects.isNull(aUpadateCategory.getDeletedAt())
        ));
        }
}
