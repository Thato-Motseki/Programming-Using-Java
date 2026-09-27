def get_score(criteria):
    while True:
        try:
            score = int(input(f"Rate {criteria} (1-5): "))
            if 1 <= score <= 5:
                return score
            print("Please enter a number between 1 and 5.")
        except ValueError:
            print("Please enter a valid number.")


def evaluate_response():
    print("=" * 50)
    print("AI RESPONSE EVALUATOR")
    print("=" * 50)

    response = input("\nPaste or describe the AI response you want to evaluate:\n> ")

    if not response.strip():
        print("No response was provided.")
        return

    criteria = [
        "Relevance",
        "Clarity",
        "Completeness",
        "Accuracy awareness"
    ]

    scores = {}

    print("\nScore each criterion from 1 (poor) to 5 (excellent).\n")

    for criterion in criteria:
        scores[criterion] = get_score(criterion)

    total = sum(scores.values())
    maximum = len(criteria) * 5
    percentage = (total / maximum) * 100

    print("\n" + "=" * 50)
    print("EVALUATION RESULT")
    print("=" * 50)

    for criterion, score in scores.items():
        print(f"{criterion}: {score}/5")

    print(f"\nOverall score: {total}/{maximum} ({percentage:.0f}%)")

    if percentage >= 80:
        assessment = "Strong response, but still verify important claims."
    elif percentage >= 60:
        assessment = "Usable response with areas that should be improved."
    else:
        assessment = "The response needs significant improvement or verification."

    print(f"Assessment: {assessment}")
    print("\nRemember: a high score does not prove that an AI response is factually correct.")


if __name__ == "__main__":
    evaluate_response()
