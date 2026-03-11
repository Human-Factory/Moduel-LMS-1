name: "✨ Feature Request"
description: "새로운 기능을 제안할 때 사용하는 템플릿입니다."
title: "[Feature] "
labels: ["✨ feature"]
assignees: []

body:
  - type: markdown
    attributes:
      value: |
        ## 기능 제안
        > 새로운 기능 아이디어를 공유해주세요. 구체적일수록 논의와 구현이 빨라집니다.

  - type: textarea
    id: summary
    attributes:
      label: "💡 기능 요약"
      description: "제안하는 기능을 한 줄로 요약해주세요."
      placeholder: "예: 사용자가 프로필 이미지를 변경할 수 있는 기능"
    validations:
      required: true

  - type: textarea
    id: motivation
    attributes:
      label: "🎯 제안 배경"
      description: "이 기능이 왜 필요한지, 어떤 문제를 해결하는지 설명해주세요."
      placeholder: |
        현재는 ~한 문제가 있습니다.
        이 기능이 추가되면 ~한 효과를 기대할 수 있습니다.
    validations:
      required: true

  - type: textarea
    id: details
    attributes:
      label: "📝 상세 설명"
      description: "기능의 구체적인 동작이나 요구사항을 작성해주세요."
      placeholder: |
        - 사용자가 설정 페이지에서 프로필 이미지를 업로드할 수 있다.
        - 지원 포맷: JPG, PNG (최대 5MB)
        - 업로드 후 미리보기가 표시된다.
    validations:
      required: true

  - type: textarea
    id: alternatives
    attributes:
      label: "🔄 대안"
      description: "이 기능 외에 고려해본 대안이 있다면 작성해주세요."
      placeholder: "예: 외부 이미지 URL 링크 방식도 고려했으나, 직접 업로드가 사용성이 더 좋다고 판단했습니다."
    validations:
      required: false

  - type: dropdown
    id: priority
    attributes:
      label: "📊 우선순위"
      description: "이 기능의 중요도를 선택해주세요."
      options:
        - "High - 핵심 기능 / MVP 필수"
        - "Medium - 있으면 좋은 기능"
        - "Low - 추후 고려"
    validations:
      required: true

  - type: textarea
    id: references
    attributes:
      label: "🔗 참고 자료"
      description: "관련 레퍼런스, 디자인, 유사 서비스 등이 있다면 첨부해주세요."
      placeholder: "링크, 스크린샷, 와이어프레임 등"
    validations:
      required: false

  - type: checkboxes
    id: checklist
    attributes:
      label: "✔️ 체크리스트"
      description: "제출 전 확인해주세요."
      options:
        - label: "동일하거나 유사한 기능 제안이 이미 등록되어 있는지 확인했습니다."
          required: true
        - label: "팀원과 사전 논의를 완료했습니다."
          required: false
