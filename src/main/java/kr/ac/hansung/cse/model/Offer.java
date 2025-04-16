package kr.ac.hansung.cse.model;

// Bean Validation용 어노테이션 (유효성 검사용)
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

// Lombok: 반복되는 코드 자동 생성용 어노테이션
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok을 통해 getter/setter, toString, 기본 생성자 자동 생성
@Getter                  // 각 필드에 대한 getter 메서드 생성
@Setter                  // 각 필드에 대한 setter 메서드 생성
@ToString                // toString() 메서드를 자동 구현
@NoArgsConstructor       // 기본 생성자 자동 생성
public class Offer {

    // 고유 식별자 (예: DB의 PK)
    private int id;

    // 이름 필드: 최소 2자, 최대 100자 허용
    @Size(min=2, max=100, message = "Name must be between 2 and 100 chars")
    private String name;

    // 이메일 필드:
    // 1) 이메일 형식이어야 하고
    // 2) 비어 있으면 안 됨
    @Email(message="Please provide a valid email address")
    @NotEmpty(message="The email address cannot be empty")
    private String email;

    // 텍스트 필드: 최소 5자, 최대 100자 허용
    @Size(min=5, max=100, message="Text must be between 5 and 100 chars")
    private String text;
}